package jports.b3.up2data;

/**
 * UP2DATA – Interest Rate Settlement Price
 * 
 * @author Giovanna Marinelli
 *
 */
@Up2DataTable(channel = "Interest_Rate", 
	subChannel = "SettlementPrice", 
	prefix = "Interest_Rate_EOD_SettlementPriceFile_Futures_")
public class InterestRateSettlementPrice extends SettlementPrice {

}
