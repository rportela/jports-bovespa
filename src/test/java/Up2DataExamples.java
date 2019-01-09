import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.gson.GsonBuilder;

import jports.GenericLogger;
import jports.b3.up2data.EquityInstrument;
import jports.b3.up2data.OptionOnEquitiesInstrument;
import jports.b3.up2data.Up2Data;

public class Up2DataExamples {

	/**
	 * This is the root folder of the UP2DATA installation.
	 */
	private static final String UP2DATA_ROOT = "L:\\UP2DATA";

	/**
	 * Reads a list of equity instruments from the most recent file.
	 * 
	 * @throws IOException
	 */
	public void readEquityInstruments() throws IOException {

		Up2Data<EquityInstrument> up2data = new Up2Data<>(UP2DATA_ROOT, EquityInstrument.class);
		List<File> allFiles = up2data.getAllFiles();

		// This assumes that the files were written from oldest to newest. Optionally
		// you can sort the list by file name or date to make sure your're reading the
		// last one.
		File last = allFiles.get(allFiles.size() - 1);

		// Equities_EquityInstrumentFile_yyyyMMdd.txt
		System.out.println(last.getName());

		// parses the file
		List<EquityInstrument> equities = up2data.parseFile(last);

		// just writes the first one as json so you can see how it looks like
		if (!equities.isEmpty()) {
			System.out.println(
					new GsonBuilder()
							.setPrettyPrinting()
							.create()
							.toJson(
									equities.get(0)));
		}

		/**
		 * <pre>
		 * {
		"report_date": "Dec 12, 2018, 12:00:00 AM",
		"ticker": "AALL34",
		"security_id": 200000224542,
		"security_source": 8,
		"exchange": "BVMF",
		"asset": "AALL",
		"asset_description": "AALL",
		"segment": "CASH",
		"market": "EQUITY-CASH",
		"description": "AMERICAN AIRDRN",
		"category": "BDR",
		"trade_start": "Nov 1, 2018, 12:00:00 AM",
		"trade_end": "Dec 31, 9999, 12:00:00 AM",
		"isin": "BRAALLBDR003",
		"cfi_code": "EDSXPR",
		"payment_type": "NETTING",
		"allocation_round_lot": 1,
		"currency": "BRL",
		"distribution": 110,
		"specification": "DRN",
		"company_name": "AMERICAN AIRLINES GROUP INC.",
		"price_factor": 1,
		"corporate_action_start": "Dec 31, 9999, 12:00:00 AM",
		"ex_distribution_number": 0,
		"custody_type": "FUNGIBLE",
		"market_cap": 4.92588818E8,
		"first_price": 160.8658302,
		"last_price": 160.8658302,
		"governance": "",
		"days_to_settlement": 3,
		"rights_issue_price": 0.0,
		"underlying_instrument_id": "",
		"asset_sub_type": "",
		"target_instrument_id": ""
		}
		 * 
		 * </pre>
		 */

	}

	public void readOptionsOnEquitiesInstruments() throws IOException {
		
		Up2Data<OptionOnEquitiesInstrument> up2data = new Up2Data<>(UP2DATA_ROOT, OptionOnEquitiesInstrument.class);
		List<File> allFiles = up2data.getAllFiles();

		// This assumes that the files were written from oldest to newest. Optionally
		// you can sort the list by file name or date to make sure your're reading the
		// last one.
		File last = allFiles.get(allFiles.size() - 1);

		// Equities_OptionOnEquitiesInstrumentFile__yyyyMMdd_1.txt
		System.out.println(last.getName());

		// parses the file
		List<OptionOnEquitiesInstrument> options = up2data.parseFile(last);

		// just writes the first one as json so you can see how it looks like
		if (!options.isEmpty()) {
			System.out.println(
					new GsonBuilder()
							.setPrettyPrinting()
							.create()
							.toJson(
									options.get(0)));
		}
	}

	public static void main(String... args) {
		try {
			new Up2DataExamples().readOptionsOnEquitiesInstruments();
		} catch (IOException e) {
			GenericLogger.error(null, e);
		}
	}

}
