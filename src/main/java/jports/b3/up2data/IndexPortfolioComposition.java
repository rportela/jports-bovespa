package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – PortfolioComposition
 * 
 * Portfolio composition of B3's indexes (E.g. Ibovespa, SMLL, UTIL, etc)
 * 
 * @author Giovanna Marinelli
 *
 */

@Up2DataTable(channel = "Index", subChannel = "PortfolioComposition", prefix = "Index_PortfolioCompositionFile_")
public class IndexPortfolioComposition {

	/**
	 * Reference date of the information.
	 */
	@Up2DataColumn(name = "RptDt", format = "yyyy-MM-dd")
	public Date report_date;

	/**
	 * Letters that identify a stock traded on a stock exchange. The Ticker
	 * Symbol is a short and convenient way of identifying a stock.
	 */
	@Up2DataColumn(name = "TckrSymb")
	public String ticker;

	/**
	 * International Securities Identification Number (ISIN).
	 * 
	 * <p>
	 * A numbering system designed by the United Nation's International
	 * Organization for Standardization (ISO). The ISIN is composed of a
	 * 2-character prefix representing the country of issue, followed by the
	 * national security number (if one exists), and a check digit. Each country
	 * has a national numbering agency that assigns ISIN numbers for securities
	 * in that country.
	 * </p>
	 */
	@Up2DataColumn(name = "ISIN")
	public String isin;

	/**
	 * This field provides corporation name.
	 */
	@Up2DataColumn(name = "CrpnNm")
	public String company_name;

	/**
	 * Code of specification of the stock e.g.: ON, PN.
	 */
	@Up2DataColumn(name = "SpcfctnCd")
	public String specification;

	/**
	 * Instrument theoretical quantity.
	 */
	@Up2DataColumn(name = "ThrlQty")
	public Long theoretical_qty;

	/**
	 * Closing price of the day. 1.8
	 */
	@Up2DataColumn(name = "LastPric")
	public Double last_price;

	/**
	 * Economic Value is the multiplication of the theoretical quantity
	 * (ThrlQty) by closure(LastPric).
	 */
	@Up2DataColumn(name = "EcncVal")
	public Double amt;

	/**
	 * This field contains the fluctuations by individual papers in the
	 * determination of the total index
	 */
	@Up2DataColumn(name = "StockPrtcptnPct")
	public Double pct_part;

	/**
	 * Status of the data on file. E.g.: I - Included, E - Excluded
	 */
	@Up2DataColumn(name = "DataSts")
	public String data_status;

}
