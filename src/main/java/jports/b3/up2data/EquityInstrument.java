package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – EquityInstrumentFile
 * 
 * @author rportela
 *
 */
@Up2DataTable(
		channel = "Equities",
		subChannel = "SecurityList",
		prefix = "Equities_EquityInstrumentFile_")
public class EquityInstrument extends Instrument {

	/**
	 * Code that identifies how the economic indicator value is expressed, e.g.,
	 * price or rate. This field requires an external code list. Those codes and
	 * values have been made external spreadsheet files to allow a flexible
	 * maintenance according to the updates requirements from BVMF. In this case the
	 * external is ExternalValueTypeCode in the file ExternalCodeLists_BVMF.xls
	 */
	@Up2DataColumn(
			name = "ValTpCd")
	public Integer value_type_code;

	/**
	 * Asset Sub Type.
	 * <p>
	 * This field requires an external code list. Those codes and values have been
	 * made external spreadsheet files to allow a flexible maintenance according to
	 * the updates requirements from BVMF. In this case the external is
	 * ExternalAssetSubTypeCode in the file ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "AsstSubTp")
	public String asset_sub_type;

	/**
	 * AuctionType.
	 * <p>
	 * This field requires an external code list. Those codes and values have been
	 * made external spreadsheet files to allow a flexible maintenance according to
	 * the updates requirements from BVMF. In this case the external is
	 * ExternalAuctionInstrumentTypeCode in the file ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "AuctnTp")
	public Integer auction_type;

	/**
	 * Code of specification of the stock e.g.: ON, PN.
	 */
	@Up2DataColumn(
			name = "SpcfctnCd")
	public String specification;

	/**
	 * This field provides corporation name.
	 */
	@Up2DataColumn(
			name = "CrpnNm")
	public String company_name;

	/**
	 * Starting date of Corporate Action (dividends or bonuses distributed to
	 * shareholders by the company).
	 */
	@Up2DataColumn(
			name = "CorpActnStartDt",
			format = "yyyy-MM-dd")
	public Date corporate_action_start;

	/**
	 * Code distribution instrument EX.
	 */
	@Up2DataColumn(
			name = "EXDstrbtnNb")
	public Integer ex_distribution_number;

	/**
	 * Provides the custody treatment type code.
	 * 
	 * <p>
	 * This field requires a list of external code. These codes and values were made
	 * in external spreadsheets to enable flexible maintenance in accordance with
	 * the requirements of the BM&FBOVESPA updates. In this case the external file
	 * is in ExternalCustodyTreatmentTypeCode in the ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "CtdyTrtmntTp")
	public String custody_type;

	/**
	 * Share capital value of the legal entity (resident, non resident or non
	 * resident with CVM).
	 */
	@Up2DataColumn(
			name = "MktCptlstn")
	public Double market_cap;

	/**
	 * Opening price of the day.
	 */
	@Up2DataColumn(
			name = "FrstPric")
	public Double first_price;

	/**
	 * Closing price of the day.
	 */
	@Up2DataColumn(
			name = "LastPric")
	public Double last_price;

	/**
	 * <p>
	 * A Governance Indicator represents the corporate governance level, classified
	 * according to the number of rules or practices adopted, e.g., level 1, level
	 * 2, new market. Example:
	 * </p>
	 * <ul>
	 * <li>"N1" - "Nivel 1",</li>
	 * <li>"N2" - "Nível 2",</li>
	 * <li>"NM" - "Novo mercado",</li>
	 * <li>"MB" - "Mercado de Balcao",</li>
	 * <li>"MA" - "Bovespa Mais.</li>
	 * </ul>
	 * <p>
	 * The Corporate Governance consists of a standardization of practices and
	 * relationships between Stockholders / Stockholders, the Board of Directors,
	 * Executive Officers, Independent Audit and Audit Committee, in order to
	 * optimize business performance and facilitate the access to capital.
	 * </p>
	 * <p>
	 * This field requires a list of external code. These codes and values were made
	 * in external spreadsheets to enable flexible maintenance in accordance with
	 * the requirements of the BM&FBOVESPA updates. In this case the external file
	 * is in ExternalGovernanceIndicatorCode ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "GovnInd")
	public String governance;

	/**
	 * It provides the rights issue price
	 */
	@Up2DataColumn(
			name = "RghtsIssePric")
	public Double rights_issue_price;
}
