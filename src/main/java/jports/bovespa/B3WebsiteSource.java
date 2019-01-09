package jports.bovespa;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

public class B3WebsiteSource {

	/**
	 * Gera uma lista de Capital Social, lida a partir do excel disponibilizado pela
	 * B3
	 * 
	 * @author gmarinelli
	 * @return
	 * @throws IOException
	 */
	public List<BovespaCapitalSocial> fetchCapitalSocial() throws IOException {

		URL url = new URL("http://www.b3.com.br/data/files/35/32/54/96/D93EF5103EE99DF5790D8AA8/Capital%20Social.xlsx");
		List<BovespaCapitalSocial> capSociais = new ArrayList<>();
		BovespaParser parsers = new BovespaParser();

		try (InputStream urlStream = url.openStream()) {
			try (Workbook workbook = new XSSFWorkbook(urlStream)) {
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

					BovespaCapitalSocial cs = new BovespaCapitalSocial();

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

			}
		}

		return capSociais;

	}

	private Map<String, List<BovespaSerieHistorica>> fetchSerieHistorica(String fileUrl) throws IOException {
		URL url = new URL(fileUrl);
		BovespaParser parser = new BovespaParser();
		try (InputStream inputStream = url.openStream()) {
			try (ZipInputStream zis = new ZipInputStream(inputStream)) {
				Map<String, List<BovespaSerieHistorica>> map = new HashMap<>();
				ZipEntry entry;
				while ((entry = zis.getNextEntry()) != null) {
					map.put(entry.getName(), parser.parseSerieHistorica(zis));
				}
				return map;
			}
		}
	}

	/**
	 * Fetches "serie histórica anual" from B3.
	 * 
	 * @param ano
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<BovespaSerieHistorica>> fetchSerieHistorica(int ano) throws IOException {
		return fetchSerieHistorica("http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_A" + ano + ".ZIP");
	}

	/**
	 * Fetches "serie histórica mensal" from B3.
	 * 
	 * @param ano
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<BovespaSerieHistorica>> fetchSerieHistorica(int ano, int mes) throws IOException {
		String fileUrl = "http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_M" +
				(mes < 10
						? ("0" + mes)
						: mes) +
				ano +
				".ZIP";
		return fetchSerieHistorica(fileUrl);
	}

	/**
	 * Fetches "serie histórica diaria" from B3.
	 * 
	 * @param ano
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<BovespaSerieHistorica>> fetchSerieHistorica(Date date) throws IOException {
		String dateFormatted = new SimpleDateFormat("ddMMyyyy").format(date);
		String fileUrl = "http://bvmf.bmfbovespa.com.br/InstDados/SerHist/COTAHIST_D" + dateFormatted + ".ZIP";
		return fetchSerieHistorica(fileUrl);
	}

}
