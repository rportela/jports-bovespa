package jports.bovespa;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
		List<BovespaCapitalSocial> capSociais = new ArrayList<BovespaCapitalSocial>();
		BovespaParsers parsers = new BovespaParsers();

		try (InputStream urlStream = url.openStream()) {
			try (Workbook workbook = new XSSFWorkbook(urlStream)) {
				Sheet datatypeSheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = datatypeSheet.iterator();

				// Dont read first as second lines (some headers are merged cells)
				iterator.next();
				iterator.next();

				String nome_pregao = "";
				String codigo = "";
				String denom_social = "";
				String segmento_mercado = "";

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
						nome_pregao = cellList.get(0).getStringCellValue().trim();
						codigo = cellList.get(1).getStringCellValue().trim();
						denom_social = cellList.get(2).getStringCellValue().trim();
						segmento_mercado = cellList.get(3).getStringCellValue().trim();

					}

					if (!cellList.get(4).getStringCellValue().trim().isEmpty()) {
						cs.nome_pregao = nome_pregao;
						cs.codigo = codigo;
						cs.denom_social = denom_social;
						cs.segmento_mercado = segmento_mercado;
						cs.tipo_de_capital = cellList.get(4).getStringCellValue().trim();
						cs.capital = cellList.get(5).getNumericCellValue();
						cs.aprovado_em = parsers.dayMonthYear(cellList.get(6).getStringCellValue().trim());
						cs.qtd_on = Double.valueOf(cellList.get(7).getNumericCellValue()).intValue();
						cs.qtd_pn = Double.valueOf(cellList.get(8).getNumericCellValue()).intValue();
						cs.qtd_total = Double.valueOf(cellList.get(9).getNumericCellValue()).intValue();
						cs.classe_1 = cellList.get(10).getStringCellValue().trim();
						cs.qtd_classe_1 = Double.valueOf(cellList.get(11).getNumericCellValue()).intValue();
						cs.classe_2 = cellList.get(12).getStringCellValue().trim();
						cs.qtd_classe_2 = Double.valueOf(cellList.get(13).getNumericCellValue()).intValue();
						cs.classe_3 = cellList.get(14).getStringCellValue().trim();
						cs.qtd_classe_3 = Double.valueOf(cellList.get(15).getNumericCellValue()).intValue();
						cs.classe_4 = cellList.get(16).getStringCellValue().trim();
						cs.qtd_classe_4 = Double.valueOf(cellList.get(17).getNumericCellValue()).intValue();
						cs.classe_5 = cellList.get(18).getStringCellValue().trim();
						cs.qtd_classe_5 = Double.valueOf(cellList.get(19).getNumericCellValue()).intValue();
						cs.classe_6 = cellList.get(20).getStringCellValue().trim();
						cs.qtd_classe_6 = Double.valueOf(cellList.get(21).getNumericCellValue()).intValue();
					}
					cs.updated_at = new Date();

					capSociais.add(cs);
				}
				workbook.close();
			} finally {
				urlStream.close();
			}
		}

		return capSociais;

	}
}
