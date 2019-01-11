package jports.bovespa;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This is CACHE first data access to Bovespa file data. You can instantiate
 * this class directly without providing a local cache path. In this case, URL
 * streams will be used and the files will not be downloaded and cached.
 * 
 * @author rportela
 *
 */
public class BovespaDataSource {

	private final String localCachePath;

	public BovespaDataSource(String localCachePath) {
		this.localCachePath = localCachePath;
	}

	private String formatDailyFileName(String prefix, String sufix) {
		String ymd = new SimpleDateFormat("_yyyy_MM_dd").format(new Date());
		return prefix + ymd + sufix;
	}

	private InputStream locateInputStream(URL remote, boolean override, String... local) throws IOException {
		if (localCachePath == null) {
			return remote.openStream();
		} else {
			Path localPath = Paths.get(localCachePath, local);
			if (override || !localPath.toFile().exists()) {
				Files.createDirectories(localPath.getParent());
				try (InputStream in = remote.openStream()) {
					try (OutputStream out = Files.newOutputStream(localPath)) {
						byte[] buff = new byte[4096];
						for (int n = in.read(buff); n >= 0; n = in.read(buff)) {
							out.write(buff, 0, n);
						}
					}
				}
			}
			return Files.newInputStream(localPath);
		}
	}

	/**
	 * Gera uma lista de Capital Social, lida a partir do excel disponibilizado pela
	 * B3
	 * 
	 * @author gmarinelli
	 * @return
	 * @throws IOException
	 */
	public List<CapitalSocial> fetchCapitalSocial() throws IOException {

		URL remote = new URL(
				"http://www.b3.com.br/data/files/35/32/54/96/D93EF5103EE99DF5790D8AA8/Capital%20Social.xlsx");

		try (InputStream is = locateInputStream(
				remote,
				false,
				"capital_social",
				formatDailyFileName("capital_social", ".xlsx"))) {
			return new BovespaParser().parseCapitalSocial(is);
		}
	}

	/**
	 * Fetches "serie histórica anual" from B3.
	 * 
	 * @param ano
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<SerieHistorica>> fetchSerieHistorica(int ano) throws IOException {

		String fileName = "COTAHIST_A" + ano + ".ZIP";
		URL remote = new URL(
				"http://bvmf.bmfbovespa.com.br/InstDados/SerHist/" + fileName);

		try (InputStream in = locateInputStream(
				remote,
				false,
				"serie_historica",
				fileName)) {
			return new BovespaParser().parseSerieHistoricaZip(in);
		}

	}

	/**
	 * Fetches "serie histórica mensal" from B3.
	 * 
	 * @param ano
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<SerieHistorica>> fetchSerieHistorica(int ano, int mes) throws IOException {

		String fileName = "COTAHIST_M" +
				(mes < 10
						? ("0" + mes)
						: mes) +
				ano +
				".ZIP";

		URL remote = new URL(
				"http://bvmf.bmfbovespa.com.br/InstDados/SerHist/" + fileName);

		try (InputStream in = locateInputStream(
				remote,
				false,
				"serie_historica",
				fileName)) {
			return new BovespaParser().parseSerieHistoricaZip(in);
		}

	}

	/**
	 * Fetches "serie histórica diaria" from B3.
	 * 
	 * @param ano
	 * @return
	 * @throws IOException
	 */
	public Map<String, List<SerieHistorica>> fetchSerieHistorica(Date date) throws IOException {

		String fileName = "COTAHIST_D" + new SimpleDateFormat("ddMMyyyy").format(date) + ".ZIP";
		URL remote = new URL(
				"http://bvmf.bmfbovespa.com.br/InstDados/SerHist/" + fileName);

		try (InputStream in = locateInputStream(
				remote,
				false,
				"serie_historica",
				fileName)) {
			return new BovespaParser().parseSerieHistoricaZip(in);
		}
	}

	/**
	 * Os empréstimos de ativos são regidos por contratos registrados
	 * voluntariamente por vontade comum das partes envolvidas ou compulsoriamente
	 * pela B3 em casos excepcionais, para investidores tomadores que ainda assim
	 * devem contar com a intenção de um ou mais investidores doadores. Em ambos os
	 * casos, as características dos contratos são definidas pelos atributos que a
	 * B3 permite a parametrização na etapa de registro de ofertas antes de serem
	 * levados em consideração os demais requisitos necessários para validação do
	 * contrato.
	 * 
	 * @param input_stream
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public List<PosicoesEmAberto> fetchPosicoesEmAberto() throws IOException,
			ParseException {

		String fileName = formatDailyFileName("SI_D_DBTCPARF", ".txt");
		URL remote = new URL(
				"ftp://ftp.bmf.com.br/ipnv2/SVI/DBTCPARF/SI_D_DBTCPARF.txt");

		try (InputStream in = locateInputStream(
				remote,
				false,
				"posicoes_em_aberto",
				fileName)) {
			return new BovespaParser().parsePosicoesEmAberto(in);
		}

	}

}
