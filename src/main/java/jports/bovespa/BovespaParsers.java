package jports.bovespa;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BovespaParsers {

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

}
