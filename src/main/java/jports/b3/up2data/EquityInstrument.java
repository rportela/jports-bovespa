package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – EquityInstrumentFile
 * 
 * Example: RptDt; TckrSymb; SctyId; SctySrc; MktIdrCd; Asst; AsstDesc; Sgmt;
 * Mkt; Desc; SctyCtgy;
 * TradgStartDt;TradgEndDt;ISIN;CFICd;PmtTp;AllcnRndLot;TradgCcy;ValTpCd;DstrbtnId;SpcfctnCd;CrpnNm;PricFctr;CorpActnStartDt;EXDstrbtnNb;CtdyTrtmntTp;MktCptlstn;FrstPric;LastPric;GovnInd;DaysToSttlm;RghtsIssePric;UndrlygInstrmId;AsstSubTp;TrgtInstrmId;AuctnTp;DataSts
 * 2018-12-11; AALL34; 200000224542; 8; BVMF; AALL; AALL; CASH; EQUITY-CASH;
 * AMERICAN AIRDRN;
 * BDR;2018-11-01;9999-12-31;BRAALLBDR003;EDSXPR;NETTING;1;BRL;;110;DRN;AMERICAN_AIRLINES
 * GROUP_INC.;1;9999-12-31;0;FUNGIBLE;492588818;160.8658302;160.8658302;;3;0;;;;;I
 * 
 * @author rportela
 *
 */
@Up2DataTable(
		channel = "Equities",
		subChannel = "SecurityList",
		prefix = "Equities_EquityInstrumentFile_")
public class EquityInstrument {

	/**
	 * Reference date of the information.
	 */
	@Up2DataColumn(
			name = "RptDt",
			format = "yyyy-MM-dd")
	public Date report_date;

	/**
	 * Letters that identify a stock traded on a stock exchange. The Ticker Symbol
	 * is a short and convenient way of identifying a stock.
	 */
	@Up2DataColumn(
			name = "TckrSymb")
	public String ticker;

	/**
	 * Unique numeric code used to identify the instrument in the B3 trading
	 * environment.
	 */
	@Up2DataColumn(
			name = "SctyId")
	public long security_id;

	/**
	 * Qualifier of the instrument. Valid value for this field is “8”.
	 */
	@Up2DataColumn(
			name = "SctySrc")
	public Integer security_source;

	/**
	 * Market Identifier Code. Identification the exchange as stipulated in the norm
	 * ISO 10383 "Codes for exchanges and market identifications". This tag is
	 * optional and if no Security Exchange is provided - it is assumed to be a BVMF
	 * instrument. Default Value = "BVMF" (SecurityExchange)
	 */
	@Up2DataColumn(
			name = "MktIdrCd")
	public String exchange;

	/**
	 * Asset associated with the security , such as DOL, BGI, OZ1, WDL, CNI, ICF,
	 * CCM, PETR etc.
	 */
	@Up2DataColumn(
			name = "Asst")
	public String asset;

	/**
	 * Commodity Description
	 */
	@Up2DataColumn(
			name = "AsstDesc")
	public String asset_description;

	/**
	 * A Segment represents the first level of market classification in the post
	 * trade process. Example: 1 - Equity - Cash; 2 - Equity derivative; 3 -
	 * Corporate bonds; 4 - Agribusiness; 5 - Financial; 6 - Metal; 7 - Energy; 8 -
	 * Gov. Bonds; 9 - FX; This field requires an external code list. Those codes
	 * and values have been made external spreadsheet files to allow a flexible
	 * Taxonomy Catalog maintenance according to the updates requirements from BVMF.
	 * In this case the external is ExternalSegmentCode in the file
	 * ExternalCodeLists_BVMF.xls
	 */
	@Up2DataColumn(
			name = "Sgmt")
	public String segment;

	/**
	 * A Market represents the Second level of market classification in the post
	 * trade process. Example: 1 - Spot; 2 - Future; 3 - Options on Spot; 4 -
	 * Options on Future; 5 - Forward; 10 - Cash; 12 - Options exercise (call); 13 -
	 * Options exercise (put); 17 - Auction; 20 - Odd Lot; 30 - Equity Forward; 70 -
	 * Equity Call; 80 - Equity Put; This field requires an external code list.
	 * Those codes and values have been made external spreadsheet files to allow a
	 * flexible maintenance according to the updates requirements from BVMF. In this
	 * case the external is ExternalMarketCode
	 */
	@Up2DataColumn(
			name = "Mkt")
	public String market;

	/**
	 * Description of Security in the Trade Structure system, e.g., Opção sobre
	 * ação, Opção sobre índice, Ouro, Futuro de Dolar, Swap Cambial, Rolagem de
	 * Soja, FWD Points DOL and so on.
	 */
	@Up2DataColumn(
			name = "Desc")
	public String description;

	/**
	 * A Security Category represents the third level of market classification in
	 * the post trade process.
	 */
	@Up2DataColumn(
			name = "SctyCtgy")
	public String category;

	/**
	 * Start date of negotiation of the financial instrument.
	 */
	@Up2DataColumn(
			name = "TradgStartDt",
			format = "yyyy-MM-dd")
	public Date trade_start;

	/**
	 * Completion date of negotiation of the financial instrument.
	 */
	@Up2DataColumn(
			name = "TradgEndDt",
			format = "yyyy-MM-dd")
	public Date trade_end;

	/**
	 * International Securities Identification Number (ISIN).
	 * 
	 * <p>
	 * A numbering system designed by the United Nation's International Organisation
	 * for Standardisation (ISO). The ISIN is composed of a 2-character prefix
	 * representing the country of issue, followed by the national security number
	 * (if one exists), and a check digit. Each country has a national numbering
	 * agency that assigns ISIN numbers for securities in that country.
	 * </p>
	 */
	@Up2DataColumn(
			name = "ISIN")
	public String isin;

	/**
	 * Code that classifies the instrument.
	 */
	@Up2DataColumn(
			name = "CFICd")
	public String cfi_code;

	/**
	 * Specifies how the transaction is to be settled.
	 * 
	 * <p>
	 * This field requires a list of external code. These codes and values were made
	 * in external spreadsheets to enable flexible maintenance in accordance with
	 * the requirements of the BM&FBOVESPA updates. In this case the external file
	 * is in ExternalPaymentTypeCode ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "PmtTp")
	public String payment_type;

	/**
	 * Pre-defined lot size for allocation purposes.
	 */
	@Up2DataColumn(
			name = "AllcnRndLot")
	public Integer allocation_round_lot;

	/**
	 * This attribute has the code of the trading currency.
	 * 
	 * <p>
	 * This field requires a list of external code. These codes and values were made
	 * in external spreadsheets to enable flexible maintenance in accordance with
	 * the requirements of the BM&FBOVESPA updates. In this case the external file
	 * is in ExternalActiveOrHistoricCurrencyCode ExternalCodeLists_BVMF.xls
	 * </p>
	 */
	@Up2DataColumn(
			name = "TradgCcy")
	public String currency;

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
	 * Distribution code of the paper Code that identifies the version of the asset.
	 * The pair "ISIN" + "Distribution Identification" is required for instruments
	 * that have depositary, such as stocks and gold. There are no distribution for
	 * derivatives.
	 */
	@Up2DataColumn(
			name = "DstrbtnId")
	public Integer distribution;

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
	 * Factor that indicates the number of shares that make up the price. The order
	 * price is displayed based on the price factor, e.g., if price factor is 1, the
	 * order price refers to 1 share. If the price factor is 1000, the order price
	 * represents the price of 1000 shares.
	 */
	@Up2DataColumn(
			name = "PricFctr")
	public Integer price_factor;

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
	 * Indicates number of days to settlement.
	 */
	@Up2DataColumn(
			name = "DaysToSttlm")
	public Integer days_to_settlement;

	/**
	 * It provides the rights issue price
	 */
	@Up2DataColumn(
			name = "RghtsIssePric")
	public Double rights_issue_price;

	/**
	 * Contains the identification underlying instrument
	 */
	@Up2DataColumn(
			name = "UndrlygInstrmId")
	public String underlying_instrument_id;

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
	 * In this case the instrument that replaces this one in case of corporate
	 * event.
	 */
	@Up2DataColumn(
			name = "TrgtInstrmId")
	public String target_instrument_id;

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
}
