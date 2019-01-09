package jports.b3.up2data;

import jports.adapters.BooleanAsSpecificString;

@Up2DataTable(
		channel = "Equities",
		subChannel = "SecurityList",
		prefix = "Equities_OptionOnEquitiesInstrumentFile_")
public class OptionOnEquitiesInstrument extends Instrument {

	/**
	 * <h2>Code that identifies the type of delivery at maturity,e.g., Physical
	 * Delivery, Financial Delivery.</h2>
	 * 
	 * <p>
	 * This field requires a list of external code. These codes and values were made
	 * in external spreadsheets to enable flexible maintenance in accordance with
	 * the requirements of the BM&FBOVESPA updates. In this case the external file
	 * is in ExternalDeliveryTypeCode ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "DlvryTp")
	public String delivery_type;

	/**
	 * Predetermined price at which the holder of a derivative will buy or sell the
	 * underlying instrument.
	 */
	@Up2DataColumn(
			name = "ExrcPric")
	public Double strike;

	/**
	 * Specifies how an option can be exercised (American, European, Bermudan)
	 */
	@Up2DataColumn(
			name = "OptnStyle")
	public String option_style;

	/**
	 * Specifies whether it is a Call option (right to purchase a specific
	 * underlying asset) or a Put option (right to sell a specific underlying
	 * asset).
	 */
	@Up2DataColumn(
			name = "OptnTp")
	public String option_type;

	/**
	 * Indicates whether the option on equities have its premium paid upfront or
	 * not.
	 */
	@Up2DataColumn(
			name = "PrmUpfrntInd",
			adapter = BooleanAsSpecificString.class,
			format = "yes")
	public Boolean premium_upfront;

	/**
	 * <h2>Type of series in what concerns to strike price updates.</h2>
	 * <ul>
	 * <li>0 - "Sem correção"</li>
	 * <li>1 - "Correção pela taxa do dolar (não protegida)"</li>
	 * <li>2 - "Correção pela TJLP"</li>
	 * <li>3 - "Correção pela TR"</li>
	 * <li>4 - "Correção pelo IPCR"</li>
	 * <li>5 - "Opções de troca - SWOPTIONS"</li>
	 * <li>6 - "Opções em pontos de indices"</li>
	 * <li>7 - "Correção pela taxa do dolar (protegida)"</li>
	 * <li>8 - "Correção pelo IGP-M - opções protegidas"</li>
	 * <li>9 - "Correção pela URV"</li>
	 * <li>234 - "Correção pelo DISeries'</li>
	 * </ul>
	 * <p>
	 * This field requires a list of external code. These codes and values were made
	 * in external spreadsheets to enable flexible maintenance in accordance with
	 * the requirements of the BM&FBOVESPA updates. In this case the external file
	 * is in ExternalSeriesTypeCode ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "SrsTp")
	public String series_type;

	/**
	 * Indicates that the switch is protected against corporate events. That is, in
	 * the case of events, the price of options can be adjusted.
	 */
	@Up2DataColumn(
			name = "PrtcnFlg",
			adapter = BooleanAsSpecificString.class,
			format = "yes")
	public Boolean is_protected;

	/**
	 * Defines whether the Option is automatically exercised.
	 */
	@Up2DataColumn(
			name = "AutomtcExrcInd",
			adapter = BooleanAsSpecificString.class,
			format = "yes")
	public Boolean automatic_exercise;

}
