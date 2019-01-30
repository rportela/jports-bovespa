import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jports.bovespa.BovespaDataSource;
import jports.bovespa.BovespaParser;
import jports.bovespa.IsinFile;
import jports.bovespa.IsinFileEmissor;
import jports.bovespa.IsinFileTitulo;
import jports.bovespa.Negs;

public class CsvFileTests {

	private static final String localCache = "L:\\B3";

	@Test
	public void testIsin() throws IOException {

		IsinFile isin = new BovespaParser().parseIsin(getClass().getResourceAsStream("isinp.zip"));

		List<IsinFileEmissor> emissores = isin.getEmissores();
		List<IsinFileTitulo> titulos = isin.getTitulos();

		emissores.stream().forEach(t -> System.out.println(t.nome));

		Assert.assertTrue(emissores != null);
		Assert.assertTrue(!emissores.isEmpty());
		Assert.assertTrue(titulos != null);
		Assert.assertTrue(!titulos.isEmpty());

	}

	@Test
	public void testNegsMercadoAVista() throws ParseException,
			IOException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-09");
		List<Negs> negs = new BovespaDataSource(localCache).fetchNegsMercadoAVista(date);
		Assert.assertTrue(negs != null);
		Assert.assertTrue(!negs.isEmpty());
	}

}
