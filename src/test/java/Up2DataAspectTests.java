import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jports.b3.up2data.EquityInstrument;
import jports.b3.up2data.Up2Data;

public class Up2DataAspectTests {

	public static final String U2DATA_ROOT = "L:\\UP2DATA";

	@Test
	public void testEquitiesEquityInstrumentsFile() throws ParseException {
		Up2Data<EquityInstrument> u2data = new Up2Data<>(U2DATA_ROOT, EquityInstrument.class);
		File[] files = u2data.getFiles(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-10"));
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
	}

	@Test
	public void testEquitiesEquityInstrumentsLatestFile() throws ParseException {
		Up2Data<EquityInstrument> u2data = new Up2Data<>(U2DATA_ROOT, EquityInstrument.class);
		File file = u2data.getLatestFile(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-10"));
		System.out.println(file);
	}

	@Test
	public void testEquitiesEquityInstrumentsParser() throws ParseException,
			IOException {
		Up2Data<EquityInstrument> u2data = new Up2Data<>(U2DATA_ROOT, EquityInstrument.class);
		List<EquityInstrument> list = u2data.parseLatestFile(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-10"));
		Assert.assertTrue(list.size() > 0);
	}
}
