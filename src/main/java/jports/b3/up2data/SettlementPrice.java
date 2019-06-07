package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – Settlement Price
 * 
 * @author Giovanna Marinelli
 *
 */
public class SettlementPrice {

	/**
	 * Código que identifica um instrumento negociado/registrado em bolsa de
	 * valores. O símbolo é uma forma curta e conveniente de identificar um
	 * instrumento.
	 */
	@Up2DataColumn(name = "RptDt", format = "yyyy-MM-dd")
	public Date report_date;

	/**
	 * Código que identifica um instrumento negociado/registrado em bolsa de
	 * valores. O símbolo é uma forma curta e conveniente de identificar um
	 * instrumento.
	 */
	@Up2DataColumn(name = "TckrSymb")
	public String ticker;

	/**
	 * Código numérico único usado para identificar o instrumento dentro do
	 * ambiente de negociação B3.
	 */
	@Up2DataColumn(name = "SctyId")
	public String security_id;

	/**
	 * Qualificador do instrumento. O valor válido para o campo é “8”.
	 */
	@Up2DataColumn(name = "SctySrc")
	public String security_src;

	/**
	 * Código identificador da bolsa em que o instrumento está listado.
	 * Identificação do mercado financeiro, conforme estipulado na norma ISO
	 * 10383. Default = “BVMF”.
	 */

	@Up2DataColumn(name = "MktIdrCd")
	public String market_code;

	/**
	 * INTERNATIONAL SECURITIES IDENTIFICATION NUMBER
	 */
	@Up2DataColumn(name = "ISIN")
	public String isin;

	/**
	 * Este atributo contém a data de vencimento do instrumento
	 */
	@Up2DataColumn(name = "XprtnDt", format = "yyyy-MM-dd")
	public Date expires_at;

	/**
	 * Cotação ajuste (futuro) e opções com ajustes.
	 */
	@Up2DataColumn(name = "AdjstdQt")
	public Double adj_price;

	/**
	 * Cotação ajuste (futuro) e opções com ajustes (em taxa)
	 */
	@Up2DataColumn(name = "AdjstdQtTax")
	public Double adj_price_tx;

	/**
	 * Situação do ajuste do dia.
	 */
	@Up2DataColumn(name = "AdjstdQtStin")
	public String adj_price_sit;

	/**
	 * Cotação de ajuste do dia anterior (futuro).
	 */
	@Up2DataColumn(name = "PrvsAdjstdQt")
	public Double prev_adj_price;

	/**
	 * Cotação de ajuste do dia anterior (futuro) (em taxa).
	 */
	@Up2DataColumn(name = "PrvsAdjstdQtTax")
	public Double prev_adj_price_tx;

	/**
	 * Situação do ajuste do dia anterior.
	 */
	@Up2DataColumn(name = "PrvsAdjstdQtStin")
	public String prev_adj_price_sit;

	/**
	 * Diferença dos preços de ajustes do dia anterior – fechamento para
	 * derivativos
	 */
	@Up2DataColumn(name = "VartnPts")
	public Double var_points;

	/**
	 * Somente para agrícolas, conversão para real(R$) do preço de ajuste atual
	 * ou, do preço de exercício para os instrumentos de opções.
	 */
	@Up2DataColumn(name = "EqvtVal")
	public Double equivalent_value;

	/**
	 * Valor do ajuste por contrato em R$.
	 */
	@Up2DataColumn(name = "AdjstdValCtrct")
	public Double adj_value;

	/**
	 * Este campo indica se houve atualização de dados de determinado registro.
	 * Os status validos para o registro são: I = Incluído (a linha não existia
	 * na publicação anterior). Todas as primeiras publicações do dia terão esse
	 * status; U = Atualizado (a linha já existia na publicação anterior e
	 * sofreu uma atualização em qualquer campo); D = Deletado (a linha deve ser
	 * excluída). Será mostrada uma única vez, no arquivo divulgado em seguida
	 * será realizada a exclusão. Se um novo arquivo for gerado após esse
	 * status, a informação não será mais exibida no campo; e N = Nenhum (a
	 * linha já existia na publicação
	 */
	@Up2DataColumn(name = "DataSts")
	public String status;

}
