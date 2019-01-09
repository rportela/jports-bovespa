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
import java.util.List;

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

		FixedLengthAspect<T> aspect = new FixedLengthAspect<>(dataType);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in, aspect.getCharset()));
		ArrayList<T> list = new ArrayList<>(1000);
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
	public List<BovespaProd> parseProd(InputStream in) throws IOException {
		return parseFixedLength(in, BovespaProd.class, "01");
	}

	/**
	 * Parses an input stream expecting it to be the PROD file stream;
	 * 
	 * @param prod
	 * @return
	 * @throws IOException
	 */
	public List<BovespaProd> parseProd(File prod) throws IOException {
		return parseFixedLength(prod, BovespaProd.class, "01");
	}

	/**
	 * Parses an input stream expecting it to be the Serie Histórica file stream;
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public List<BovespaSerieHistorica> parseSerieHistorica(InputStream in) throws IOException {
		return parseFixedLength(in, BovespaSerieHistorica.class, "01");
	}

	/**
	 * Parses an input stream expecting it to be the PROD file stream;
	 * 
	 * @param prod
	 * @return
	 * @throws IOException
	 */
	public List<BovespaSerieHistorica> parseSerieHistorica(File prod) throws IOException {
		return parseFixedLength(prod, BovespaSerieHistorica.class, "01");
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
	public List<BovespaPosicoesEmAberto> parsePosicoesEmAberto(InputStream is) throws IOException,
			ParseException {

		ArrayList<BovespaPosicoesEmAberto> target = new ArrayList<>(200);
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
				BovespaPosicoesEmAberto item = new BovespaPosicoesEmAberto();
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

}
