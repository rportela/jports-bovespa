package jports.bovespa;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

public class B3FtpSource {

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
	public List<BovespaPosicoesEmAberto> fetchPosicoesEmAberto() throws IOException,
			ParseException {
		URL url = new URL("ftp://ftp.bmf.com.br/ipnv2/SVI/DBTCPARF/SI_D_DBTCPARF.txt");
		InputStream urlStream = url.openStream();
		try {
			return new BovespaPosicoesEmAbertoParser().parse(urlStream);
		} finally {
			urlStream.close();
		}
	}

	public HashMap<String, List<BovespaPosicoesEmAberto>> fetchPosicoesEmAbertoZip(InputStream is) throws IOException {

		return null;
	}

}
