package jports.b3.up2data;

/**
 * UP2DATA – EquitiesEODPriceFile
 * 
 * Price information of equities at the end of the day.
 * 
 * @author Giovanna Marinelli
 *
 */

@Up2DataTable(
	channel = "Equities", 
	subChannel = "TradeInformation", 
	prefix = "Equities_EODPriceFile_")

public class EquitiesEODPrice extends EODPrice {}
