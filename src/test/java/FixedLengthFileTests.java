import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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
}
