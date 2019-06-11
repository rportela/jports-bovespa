package jports.b3.up2data;

/**
 * UP2DATA – InterestRateEODPriceFile
 * 
 * Price information of equities at the end of the day.
 * 
 * @author Giovanna Marinelli
 *
 */

@Up2DataTable(
	channel = "Interest Rate", 
	subChannel = "TradeInformation", 
	prefix = "Interest_Rate_EODPriceFile_")
public class InterestRateFutureEODPrice extends EODPrice {

}
