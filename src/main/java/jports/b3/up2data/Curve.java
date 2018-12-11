package jports.b3.up2data;

import java.util.Date;

/**
 * Example:
 * RptDt;RateCd;RateDesc;YldCrvCd;WrkgDays;VrtxChrtc;ClnrDays;VrtxCd;ThrlRate;DataSts
 * 2018-12-10;010;LTN;T1;15;Móvel;23;23;6.4259;I
 * 
 * @author rportela
 *
 */
@Up2DataTable(
		channel = "Curves",
		subChannel = "",
		prefix = "Curves_CurveFile_")
public class Curve {

	/**
	 * ReportDate: Reference date of the information.
	 */
	@Up2DataColumn(
			name = "RptDt",
			format = "yyyy-MM-dd")
	public Date report_date;

	/**
	 * RateCode: Rate code
	 */
	@Up2DataColumn(
			name = "RateCd")
	public String rate_code;

	/**
	 * RateDescription: Rate description.
	 */
	@Up2DataColumn(
			name = "RateDesc")
	public String rate_description;

	/**
	 * YieldCurveCode: Yield curve code
	 */
	@Up2DataColumn(
			name = "YldCrvCd")
	public String yield_curve_code;

	/**
	 * SecurityIdentification: Unique numeric code used to identify the instrument
	 * in the B3 trading environment.
	 */
	@Up2DataColumn(
			name = "SctyId")
	public String security_id;

	/**
	 * SecuritySource: Qualifier of the instrument. Valid value for this field is
	 * “8”.
	 */
	@Up2DataColumn(
			name = "SctySrc")
	public String security_source;

	/**
	 * MarketIdentifierCode: Market Identifier Code. Identification the exchange as
	 * stipulated in the norm ISO 10383 "Codes for exchanges and market
	 * identifications". This tag is optional and if no Security Exchange is
	 * provided - it is assumed to be a BVMF instrument. Default Value = "BVMF"
	 * (SecurityExchange)
	 */
	@Up2DataColumn(
			name = "MktIdrCd")
	public String exchange;

	/**
	 * WorkingDays: It provides the number of working days, considering the date of
	 * the session until the date of contract expiration (inclusive).
	 */
	@Up2DataColumn(
			name = "WrkgDays")
	public int working_days;

	/**
	 * VertexCharacteristic: Vertex characteristic. Ex: Fixo, Móvel.
	 */
	@Up2DataColumn(
			name = "VrtxChrtc")
	public String vertex_characteristic;

	/**
	 * CalendarDays: It provides the number of calendar days, considering the date
	 * of trading until the date of contract expiration (inclusive).
	 */
	@Up2DataColumn(
			name = "ClnrDays")
	public int calendar_days;

	/**
	 * VertexCode: Vertex code.
	 */
	@Up2DataColumn(
			name = "VrtxCd")
	public int vertex_code;

	/**
	 * TheoreticalRate: Theoretical
	 * rate.RestrictedBVMFActiveOrHistoricCurrencyAnd7DecimalAmount;
	 */
	@Up2DataColumn(
			name = "ThrlRate")
	public double theoretical_rate;

	/**
	 * An information status column?! We don't really know what this is. It's not on
	 * their documentation;
	 */
	@Up2DataColumn(
			name = "DataSts")
	public String data_status;
}
