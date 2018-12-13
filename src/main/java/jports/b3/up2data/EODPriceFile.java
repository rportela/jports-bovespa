package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – EquitiesEODPriceFile
 * 
 * Price information of several markets (channels) at the end of the day. E.g.
 * Commodities, Interest Rate, Currency, Equities, Indexes.
 * 
 * @author Giovanna Marinelli
 *
 */
public class EODPriceFile {

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
	 * Unique numeric code used to identify the instrument in the B3 trading
	 * environment.
	 */
	@Up2DataColumn(name = "SctyId")
	public long security_id;

	/**
	 * Qualifier of the instrument. Valid value for this field is “8”.
	 */
	@Up2DataColumn(name = "SctySrc")
	public String security_source;

	/**
	 * Market Identifier Code.
	 * 
	 * <p>
	 * Identification the exchange as stipulated in the norm ISO 10383 "Codes
	 * for exchanges and market identifications". This tag is optional and if no
	 * Security Exchange is provided - it is assumed to be a BVMF instrument.
	 * Default Value = "BVMF" (SecurityExchange)
	 * </p>
	 */
	@Up2DataColumn(name = "MktIdrCd")
	public String mkt_identifier_code;

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
	 * Indicates number of days to settlement.
	 */
	@Up2DataColumn(name = "DaysToSttlm")
	public String days_to_settlement;

	/**
	 * Letters that identify a stock traded on a stock exchange. The Ticker
	 * Symbol is a short and convenient way of identifying a stock.
	 */
	@Up2DataColumn(name = "FrstPric")
	public Double first_price;

	/**
	 * Minimum Price
	 */
	@Up2DataColumn(name = "MinPric")
	public Double min_price;

	/**
	 * Maximum Price
	 */
	@Up2DataColumn(name = "MaxPric")
	public Double max_price;

	/**
	 * Trade Average Price
	 */
	@Up2DataColumn(name = "TradAvrgPric")
	public Double trade_avg_price;

	/**
	 * Closing price of the day.
	 */
	@Up2DataColumn(name = "LastPric")
	public Double last_price;

	/**
	 * Rate of oscillation.
	 */
	@Up2DataColumn(name = "OscnPctg")
	public Double oscillation_pct;

	/**
	 * Trade Quantity.
	 */
	@Up2DataColumn(name = "TradQty")
	public Long trade_qty;

	/**
	 * The identifier or name of the price stream.
	 */
	@Up2DataColumn(name = "MktDataStrmId")
	public String mkt_data_stream_id;

	/**
	 * Financial volume traded (R$).
	 */
	@Up2DataColumn(name = "NtlFinVol")
	public Double traded_vol_brl;

	/**
	 * Financial traded volume (U$).
	 */
	@Up2DataColumn(name = "IntlFinVol")
	public Double traded_vol_usd;

	/**
	 * Quantity of financial instrument traded.
	 */
	@Up2DataColumn(name = "FinInstrmQty")
	public Long traded_instrument_qty;

	/**
	 * Best Bid Price.
	 */
	@Up2DataColumn(name = "BestBidPric")
	public Double best_bid_price;

	/**
	 * Best Ask Price.
	 */
	@Up2DataColumn(name = "BestAskPric")
	public Double best_ask_price;

	/**
	 * Number of Regular Transactions.
	 */
	@Up2DataColumn(name = "RglrTxsQty")
	public Long reg_transactions_num;

	/**
	 * Traded volume (R$) - After Market
	 */
	@Up2DataColumn(name = "NtlRglrVol")
	public Double traded_vol_after_brl;

	/**
	 * Traded volume (U$) - After Market
	 */
	@Up2DataColumn(name = "IntlRglrVol")
	public Double traded_vol_after_usd;

	/**
	 * Maximum trade limit.
	 */
	@Up2DataColumn(name = "MaxTradLmt")
	public Double max_trade_limit;

	/**
	 * Minimum trade limit.
	 */
	@Up2DataColumn(name = "MinTradLmt")
	public Double min_trade_limit;

	/**
	 * Quantity of open contract.
	 */
	@Up2DataColumn(name = "OpnIntrst")
	public Double open_interest;

	/**
	 * Number of Non Regular Transactions.
	 */
	@Up2DataColumn(name = "NonRglrTxsQty")
	public Long nonreg_transactions_num;

	/**
	 * Regular traded contracts.
	 */
	@Up2DataColumn(name = "RglrTraddCtrcts")
	public Long reg_traded_contracts;

	/**
	 * Non regular traded contracts.
	 */
	@Up2DataColumn(name = "NonRglrTraddCtrcts")
	public Long nonreg_traded_contracts;

	/**
	 * Non Regular Traded volume (R$) - After Market
	 */
	@Up2DataColumn(name = "NtlNonRglrVol")
	public Double nonreg_traded_volume_brl;

	/**
	 * Non Regular Traded volume (U$) - After Market
	 */
	@Up2DataColumn(name = "IntlNonRglrVol")
	public Double nonreg_traded_volume_usd;

	/**
	 * Status of the data on file. E.g.: I - Included, E - Excluded
	 */
	@Up2DataColumn(name = "DataSts")
	public String data_status;
}
