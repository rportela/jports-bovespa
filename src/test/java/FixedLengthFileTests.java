import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jports.bovespa.B3WebsiteSource;
import jports.bovespa.BovespaParser;
import jports.bovespa.BovespaProd;

public class FixedLengthFileTests {

	@Test
	public void testBovespaProd() throws IOException {

		try (InputStream prod = getClass().getResourceAsStream("PROD")) {

			List<BovespaProd> proventos = new BovespaParser().parseProd(prod);
			Assert.assertTrue(proventos.size() > 0);

		}

	}

	@Test
	public void fetchTUPY3from2010() throws IOException {
		new B3WebsiteSource().fetchSerieHistorica(2010).values().forEach(list -> {
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
