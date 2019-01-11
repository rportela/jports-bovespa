import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jports.bovespa.BovespaDataSource;
import jports.bovespa.BovespaParser;
import jports.bovespa.PosicoesEmAberto;
import jports.bovespa.Prod;

public class FixedLengthFileTests {

	private static final String localCache = "L:\\B3";

	@Test
	public void testBovespaProd() throws IOException {

		try (InputStream prod = getClass().getResourceAsStream("PROD")) {

			List<Prod> proventos = new BovespaParser().parseProd(prod);
			Assert.assertTrue(proventos.size() > 0);

		}

	}

	@Test
	public void fetchPosicoesEmAberto() throws IOException,
			ParseException {
		List<PosicoesEmAberto> posicoesEmAberto = new BovespaDataSource(localCache).fetchPosicoesEmAberto();
		Assert.assertTrue(posicoesEmAberto != null && !posicoesEmAberto.isEmpty());
	}

	@Test
	public void fetchTUPY3from2010() throws IOException {
		new BovespaDataSource(localCache).fetchSerieHistorica(2010).values().forEach(list -> {
			list.stream().filter(i -> "TUPY3".equals(i.ticker)).forEach(item -> {
				System.out.println(item.ticker +
						"-> " +
						item.data_pregao +
						" -> " +
						item.preco_ultimo +
						" -> " +
						item.preco_melhor_compra);
			});
		});
	}
}
