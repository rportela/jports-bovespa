package jports.bovespa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jports.text.FixedLengthAspect;

public class BovespaParser {

	/**
	 * This methods extracts a dd/MM/yyyy pattern from a string and parses them as
	 * date.
	 * 
	 * @param text
	 * @return
	 */
	public final Date dayMonthYear(final String text) {
		if (text == null || text.isEmpty())
			return null;
		else
			try {
				switch (text.length()) {
				case 8:
					return new SimpleDateFormat("ddMMyyyy").parse(text);
				case 10:
					return new SimpleDateFormat("dd/MM/yyyy").parse(text);
				case 16:
					return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(text);
				case 19:
					return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(text);
				default:
					throw new Exception("Unknown ymd date format for:" + text);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

	}

	/**
	 * Parses an input stream using a fixed length aspect annotated on the Class<T>
	 * dataType.
	 * 
	 * @param in
	 * @param dataType
	 * @param recordType
	 *            Every B3 fixed length file has one or two leading chars that
	 *            correspond to the recordType.
	 * @return
	 * @throws IOException
	 */
	public <T> List<T> parseFixedLength(InputStream in, Class<T> dataType, String recordType) throws IOException {
		final FixedLengthAspect<T> aspect = new FixedLengthAspect<>(dataType);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(in, aspect.getCharset()));
		final ArrayList<T> list = new ArrayList<>(1000);
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith(recordType))
				list.add(aspect.parseLine(line));
		}
		return list;
	}

	/**
	 * Parses a file using a fixed length aspect annotated on the Class<T> dataType.
	 * 
	 * @param file
	 * @param dataType
	 * @param recordType
	 *            Every B3 fixed length file has one or two leading chars that
	 *            correspond to the recordType.
	 * @return
	 * @throws IOException
	 */
	public <T> List<T> parseFixedLength(File file, Class<T> dataType, String recordType) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			return parseFixedLength(fis, dataType, recordType);
		}
	}

	/**
	 * Parses an input stream expecting it to be the PROD file stream;
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<Prod> parseProd(InputStream in) throws IOException {
		return parseFixedLength(in, Prod.class, "01");
	}

	/**
	 * Parses an input stream expecting it to be the PROD file stream;
	 * 
	 * @param prod
	 * @return
	 * @throws IOException
	 */
	public List<Prod> parseProd(File prod) throws IOException {
		return parseFixedLength(prod, Prod.class, "01");
	}

	/**
	 * Parses an input stream expecting it to be the Serie Histórica file stream;
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<SerieHistorica> parseSerieHistorica(InputStream in) throws IOException {
		return parseFixedLength(in, SerieHistorica.class, "01");
	}

	/**
	 * Extracts serie historica file data from a ZIPPED stream of files. This method
	 * returns a map containing the file name of the ZIPPED entry and the parsed
	 * serie historica list.
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<SerieHistorica>> parseSerieHistoricaZip(InputStream in) throws IOException {
		BovespaParser parser = new BovespaParser();
		try (ZipInputStream zis = new ZipInputStream(in)) {
			Map<String, List<SerieHistorica>> map = new HashMap<>();
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				map.put(entry.getName(), parser.parseSerieHistorica(zis));
			}
			return map;
		}
	}

	/**
	 * Parses an input stream expecting it to be a "posicoes em aberto" structure
	 * like SI_D_DBTCPARF.
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public List<PosicoesEmAberto> parsePosicoesEmAberto(InputStream is) throws IOException,
			ParseException {

		ArrayList<PosicoesEmAberto> target = new ArrayList<>(200);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("windows-1252")));
		String line;
		Date dataPregao = null;
		Date dataArquivo = null;

		while ((line = reader.readLine()) != null) {
			String[] cells = line.split("\\|");
			int lineType = Integer.parseInt(cells[0]);
			switch (lineType) {
			case 1:
				dataPregao = new SimpleDateFormat("yyyyMMdd").parse(cells[1]);
				dataArquivo = new SimpleDateFormat("yyyyMMddHH:mm:ss").parse(cells[2] + cells[3]);
				break;
			case 2:
				PosicoesEmAberto item = new PosicoesEmAberto();
				item.data_arquivo = dataArquivo;
				item.data_pregao = dataPregao;
				item.ticker = cells[1];
				item.nome = cells[2];
				item.tipo_ativo = cells[3];
				item.isin = cells[4];
				item.num_acoes = Long.parseLong(cells[5]);
				item.preco_medio = Double.parseDouble(cells[6]);
				item.temp = cells[7];
				item.volume = Double.parseDouble(cells[8]);
				target.add(item);
				break;
			default:
				throw new RuntimeException("Unknown record type " + lineType + " for SI_D_DBTCPARF.txt");
			}
		}

		return target;
	}

	/**
	 * Parses an input stream expecting it to be a collection of ZIPPED "posicoes em
	 * aberto" structures.
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public Map<String, List<PosicoesEmAberto>> parsePosicoesEmAbertoZip(InputStream is) throws IOException,
			ParseException {

		Map<String, List<PosicoesEmAberto>> map = new HashMap<>();
		try (ZipInputStream zis = new ZipInputStream(is)) {
			ZipEntry entry = zis.getNextEntry();
			while (entry != null) {
				map.put(entry.getName(), new BovespaParser().parsePosicoesEmAberto(zis));
				entry = zis.getNextEntry();
			}
		}
		return map;

	}

	/**
	 * Parses a list of Capital Social from an input stream containing the XLSX file
	 * from Bovespa.
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<CapitalSocial> parseCapitalSocial(InputStream in) throws IOException {
		try (Workbook workbook = new XSSFWorkbook(in)) {
			List<CapitalSocial> capSociais = new ArrayList<>();
			BovespaParser parsers = new BovespaParser();
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();

			// Don't read first and second lines (some headers are merged cells)
			iterator.next();
			iterator.next();

			String nomePregao = "";
			String codigo = "";
			String denomSocial = "";
			String segmentoMercado = "";

			while (iterator.hasNext()) {

				Row currentRow = iterator.next();

				// List of cells for each row
				List<Cell> cellList = new ArrayList<>();
				Iterator<Cell> cellIterator = currentRow.iterator();
				while (cellIterator.hasNext())
					cellList.add(cellIterator.next());

				CapitalSocial cs = new CapitalSocial();

				// Case of subscribed stocks
				if (!cellList.get(0).getStringCellValue().trim().isEmpty()) {
					nomePregao = cellList.get(0).getStringCellValue().trim();
					codigo = cellList.get(1).getStringCellValue().trim();
					denomSocial = cellList.get(2).getStringCellValue().trim();
					segmentoMercado = cellList.get(3).getStringCellValue().trim();

				}

				if (!cellList.get(4).getStringCellValue().trim().isEmpty()) {
					cs.nome_pregao = nomePregao;
					cs.codigo = codigo;
					cs.denom_social = denomSocial;
					cs.segmento_mercado = segmentoMercado;
					cs.tipo_de_capital = cellList.get(4).getStringCellValue().trim();
					cs.capital = cellList.get(5).getNumericCellValue();
					cs.aprovado_em = parsers.dayMonthYear(cellList.get(6).getStringCellValue().trim());
					cs.qtd_on = (int) cellList.get(7).getNumericCellValue();
					cs.qtd_pn = (int) cellList.get(8).getNumericCellValue();
					cs.qtd_total = (int) cellList.get(9).getNumericCellValue();
					cs.classe_1 = cellList.get(10).getStringCellValue().trim();
					cs.qtd_classe_1 = (int) cellList.get(11).getNumericCellValue();
					cs.classe_2 = cellList.get(12).getStringCellValue().trim();
					cs.qtd_classe_2 = (int) cellList.get(13).getNumericCellValue();
					cs.classe_3 = cellList.get(14).getStringCellValue().trim();
					cs.qtd_classe_3 = (int) cellList.get(15).getNumericCellValue();
					cs.classe_4 = cellList.get(16).getStringCellValue().trim();
					cs.qtd_classe_4 = (int) cellList.get(17).getNumericCellValue();
					cs.classe_5 = cellList.get(18).getStringCellValue().trim();
					cs.qtd_classe_5 = (int) cellList.get(19).getNumericCellValue();
					cs.classe_6 = cellList.get(20).getStringCellValue().trim();
					cs.qtd_classe_6 = (int) cellList.get(21).getNumericCellValue();
				}
				cs.updated_at = new Date();

				capSociais.add(cs);
			}

			return capSociais;
		}
	}
}
