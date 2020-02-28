package jports.bovespa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import jports.adapters.DateAdapter;
import jports.adapters.LongAdapter;
import jports.text.CsvAspect;
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
	 * Parses an input stream expecting it to be the PROD file stream;
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<Prod> parseProd(InputStream in) throws IOException {
		return new FixedLengthAspect<Prod>(Prod.class).parse(in);
	}

	/**
	 * Parses an input stream expecting it to be the PROD file stream;
	 * 
	 * @param prod
	 * @return
	 * @throws IOException
	 */
	public List<Prod> parseProd(File prod) throws IOException {
		return new FixedLengthAspect<Prod>(Prod.class).parse(prod);
	}

	/**
	 * Parses an input stream expecting it to be the Serie Histórica file stream;
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<SerieHistorica> parseSerieHistorica(InputStream in) throws IOException {
		return new FixedLengthAspect<SerieHistorica>(SerieHistorica.class).parse(in);
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
	public List<SerieHistorica> parseSerieHistoricaZip(InputStream in) throws IOException {
		BovespaParser parser = new BovespaParser();
		try (ZipInputStream zis = new ZipInputStream(in)) {
			if (zis.getNextEntry() != null) {
				return parser.parseSerieHistorica(zis);
			} else {
				return new ArrayList<>(0);
			}
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
		//BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("windows-1252")));
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		String line;
		Date dataPregao = null;
		Date dataArquivo = null;

		while ((line = reader.readLine()) != null) {
			String[] cells = line.split("\\|");
			String rowType = cells[0].replaceAll("[^a-zA-Z0-9]+","");
			int lineType = Integer.parseInt(rowType);
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
				
				final Calendar cal = Calendar.getInstance();
			    cal.add(Calendar.DATE, -1);

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
					cs.qtd_on = cellList.get(7).getNumericCellValue();
					cs.qtd_pn = cellList.get(8).getNumericCellValue();
					cs.qtd_total = cellList.get(9).getNumericCellValue();
					cs.classe_1 = cellList.get(10).getStringCellValue().trim();
					cs.qtd_classe_1 = cellList.get(11).getNumericCellValue();
					cs.classe_2 = cellList.get(12).getStringCellValue().trim();
					cs.qtd_classe_2 = cellList.get(13).getNumericCellValue();
					cs.classe_3 = cellList.get(14).getStringCellValue().trim();
					cs.qtd_classe_3 = cellList.get(15).getNumericCellValue();
					cs.classe_4 = cellList.get(16).getStringCellValue().trim();
					cs.qtd_classe_4 = cellList.get(17).getNumericCellValue();
					cs.classe_5 = cellList.get(18).getStringCellValue().trim();
					cs.qtd_classe_5 = cellList.get(19).getNumericCellValue();
					cs.classe_6 = cellList.get(20).getStringCellValue().trim();
					cs.qtd_classe_6 = cellList.get(21).getNumericCellValue();
					
				}
				cs.updated_at = new Date();
				cs.reference_date = cal.getTime();


				capSociais.add(cs);
			}

			return capSociais;
		}
	}

	/**
	 * Parses a stream of Titulo Negociavel as expecting it to be as described in:
	 * http://bvmf.bmfbovespa.com.br/cias-listadas/Titulos-Negociaveis/download/Titulos_Negociaveis.PDF
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public TituloNegociavelFile parseTituloNegociavel(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("windows-1252")));
		FixedLengthAspect<TituloNegociavelEmpresa> flEmpresa = new FixedLengthAspect<>(TituloNegociavelEmpresa.class);
		FixedLengthAspect<TituloNegociavel> flItem = new FixedLengthAspect<>(TituloNegociavel.class);
		String line;
		TituloNegociavelFile tn = new TituloNegociavelFile();
		while ((line = reader.readLine()) != null) {
			if (line.startsWith("01")) {
				tn.addEmpresa(flEmpresa.parseLine(line));
			} else if (line.startsWith("02")) {
				tn.addTitulo(flItem.parseLine(line));
			}
		}
		return tn;
	}

	/**
	 * Extracts and parses a stream of Titulo Negociavel expecting it to be as
	 * described in:
	 * 
	 * http://bvmf.bmfbovespa.com.br/cias-listadas/Titulos-Negociaveis/download/Titulos_Negociaveis.PDF
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public TituloNegociavelFile parseTituloNegociavelZip(InputStream in) throws IOException {
		try (ZipInputStream zis = new ZipInputStream(in)) {
			return zis.getNextEntry() != null
					? parseTituloNegociavel(zis)
					: null;
		}
	}

	/**
	 * Unfortunately, Bovespa choice of CSV separators was poor. There are records
	 * that contain the separator in them. This is a workaround to parse the file
	 * using a different separator and cleaning up the entries.
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	private List<IsinFileEmissor> parseIsinEmissores(InputStream in) throws IOException {

		ArrayList<IsinFileEmissor> emissores = new ArrayList<>(40000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		LongAdapter longAdapter = new LongAdapter();
		DateAdapter dateAdapter = new DateAdapter("yyyyMMdd");
		String line = reader.readLine();
		while (line != null) {

			String[] cells = line.split("\",\"");
			cells[0] = cells[0].substring(1);
			String lastText = cells[cells.length - 1];
			lastText = lastText.substring(0, lastText.length() - 1);
			cells[cells.length - 1] = lastText;

			IsinFileEmissor emissor = new IsinFileEmissor();
			emissor.codigo = cells[0];
			emissor.nome = cells[1];
			emissor.cnpj = longAdapter.parse(cells[2]);
			emissor.data_criacao = dateAdapter.parse(cells[3]);
			emissores.add(emissor);

			line = reader.readLine();
		}
		return emissores;
	}

	/**
	 * Extracts and parses a stream expecting it to be of type ISIN.
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public IsinFile parseIsin(InputStream in) throws IOException {
		try (ZipInputStream zis = new ZipInputStream(in)) {
			ZipEntry entry = zis.getNextEntry();
			IsinFile isin = new IsinFile();
			while (entry != null) {
				String entryName = entry.getName().toUpperCase();
				if (entryName.startsWith("EMISSOR")) {
					isin.setEmissores(parseIsinEmissores(zis));
				} else if (entryName.startsWith("NUMERACA")) {
					isin.setTitulos(new CsvAspect<>(IsinFileTitulo.class).parse(zis));
				}
				entry = zis.getNextEntry();
			}
			return isin;
		}
	}

	/**
	 * Extracts and parses a file expecting it to be of type ISIN.
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public IsinFile parseIsin(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			return parseIsin(fis);
		}
	}

	/**
	 * Parses a ZIPPED input stream expecting it to be of type NEGS as described on:
	 * 
	 * ftp://ftp.bmf.com.br/marketdata/NEG_LAYOUT_english.txt
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<Negs> parseNegs(InputStream in) throws IOException {
		try (ZipInputStream zis = new ZipInputStream(in)) {
			ZipEntry entry = zis.getNextEntry();
			if (entry != null) {
				return new CsvAspect<Negs>(Negs.class).parse(zis);
			} else {
				return new ArrayList<>(0);
			}
		}
	}
}
