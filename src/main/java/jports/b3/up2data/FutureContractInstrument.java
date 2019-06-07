package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – FutureContractInstrumentFile
 * 
 * Future Contracts Instrument
 * 
 * @author Giovanna Marinelli
 *
 */

public class FutureContractInstrument {

	/**
	 * Data de referência da informação.
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
	 * Mercadoria associada ao instrumento. Exemplos: DOL, BGI, OZ1, WDL, CNI,
	 * ICF, CCM, etc.
	 */
	@Up2DataColumn(name = "Asst")
	public String underlying;

	/**
	 * Descrição da mercadoria
	 */
	@Up2DataColumn(name = "AsstDesc")
	public String underlying_descr;

	/**
	 * <p>
	 * Segmento representa o primeiro nível da classificação de mercado no
	 * processo de pós-negociação.
	 * </p>
	 * <p>
	 * Exemplos:
	 * </p>
	 * 
	 * <ul>
	 * <li>1 - Ações – Vista</li>
	 * <li>2 - Ações – Derivativos</li>
	 * <li>3 - Renda fixa privada</li>
	 * <li>4 - Agronegócio</li>
	 * <li>5 - Financeiro</li>
	 * <li>6 - Metais</li>
	 * <li>7 - Energia elétrica</li>
	 * <li>8 - Títulos públicos</li>
	 * <li>9 - Câmbio</li>
	 * 
	 * </ul>
	 * 
	 * <p>
	 * Este campo requer uma lista de código externo. Esses códigos e valores
	 * foram feitos em planilhas externas para permitir a manutenção flexível de
	 * acordo com os requisitos de atualizações da B3. Neste caso, o externo é
	 * ExternalSegmentCode no arquivo ExternalCodeLists_BVMF.xls.
	 * </p>
	 * 
	 */
	@Up2DataColumn(name = "Sgmt")
	public String segment;

	/**
	 * <p>
	 * Representa o segundo nível da classificação de mercado no processo de
	 * pós-negociação.
	 * </p>
	 * <p>
	 * Exemplos:
	 * </p>
	 * 
	 * <ul>
	 * <li>1 - MERCADO DISPONÍVEL</li>
	 * <li>2 - MERCADO FUTURO</li>
	 * <li>3 - OPÇÕES SOBRE DISPONÍVEL</li>
	 * <li>4 - OPÇÕES SOBRE FUTURO</li>
	 * <li>5 - MERCADO A TERMO</li>
	 * <li>10 - Vista</li>
	 * <li>12 - Exercício de opções de compra</li>
	 * <li>13 - Exercício de opções de venda</li>
	 * <li>17 - Leilão</li>
	 * <li>20 - Fracionário
	 * <li>30 - Termo</li>
	 * <li>70 - OPC</li>
	 * <li>80 - OPV</li>
	 * </ul>
	 * <p>
	 * Este campo requer uma lista de código externo. Esses códigos e os valores
	 * foram criados em uma planilha externa para permitir uma manutenção
	 * flexível de acordo com os requisitos de atualizações da B3. Neste caso, o
	 * externo é ExternalMarketCode no arquivo ExternalCodeLists_BVMF.xls.
	 * </p>
	 */
	@Up2DataColumn(name = "Mkt")
	public String market_name;

	/**
	 * Descrição do instrumento no sistema de negociação (Trade System), por
	 * exemplo, Opção sobre Ação, Opção sobre Índice, Ouro, Futuro de Dólar,Swap
	 * Cambial, Rolagem de Soja, Pontos FWD DOL e assim por diante.
	 */
	@Up2DataColumn(name = "Desc")
	public String descr;

	/**
	 * A categoria de instrumento representa o terceiro nível de classificação
	 * de mercado no processo de pós-negociação. Este campo requer uma lista de
	 * código externo. Esses códigos e valores foram feitos em planilhas
	 * externas para permitir a manutenção flexível de acordo com os requisitos
	 * de atualizações da B3. Neste caso, o externo é
	 * ExternalSecurityCategoryCode no arquivo ExternalCodeLists_BVMF.xls.
	 */
	@Up2DataColumn(name = "SctyCtgy")
	public String category;

	/**
	 * Este atributo contém a data de vencimento do instrumento.
	 */
	@Up2DataColumn(name = "XprtnDt", format = "yyyy-MM-dd")
	public Date expires_at;

	/**
	 * <p>
	 * Código de expiração do contrato.
	 * </p>
	 * <p>
	 * Este atributo possui dois formatos:
	 * </p>
	 * <p>
	 * Formato: MYY
	 * </p>
	 * <ul>
	 * <li>M = Código do mês</li>
	 * <li>Y = Código do ano</li>
	 * </ul>
	 * <p>
	 * Formato: MYOA onde:
	 * </p>
	 * <ul>
	 * <li>M = Código do mês</li>
	 * <li>Y = Código do ano</li>
	 * <li>O = Código da opção</li>
	 * <li>A = Código sequencial alfanumérico</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "XprtnCd")
	public String expiration_code;

	/**
	 * Data de início da negociação do instrumento financeiro.
	 */
	@Up2DataColumn(name = "TradgStartDt", format = "yyyy-MM-dd")
	public Date trading_start;

	/**
	 * Data da conclusão da negociação do instrumento financeiro.
	 */
	@Up2DataColumn(name = "TradgEndDt", format = "yyyy-MM-dd")
	public Date trading_end;

	/**
	 * <p>
	 * Base para a contagem de dias. Número de dias no período de cálculo, por
	 * exemplo, 252, 360, 365. Este campo é usado apenas para os contratos
	 * negociados em taxa e que precisem ser convertidos para preço. Atualmente,
	 * essa situação apenas ocorre nas seguintes mercadorias
	 * </p>
	 * <ul>
	 * <li>- DDI:</li>
	 * <li>- DAP</li>
	 * <li>- DDM</li>
	 * <li>- DI1</li>
	 * <li>- DIL</li>
	 * </ul>
	 * Nota: o swap cambial é negociado em taxa mas não é convertido em preço.
	 */
	@Up2DataColumn(name = "BaseCd")
	public Integer base_code;

	/**
	 * <p>
	 * Tipo de critérios de conversão, por exemplo, linear, exponencial, não
	 * disponível. Este campo é usado apenas para os contratos negociados em
	 * taxa e que precisem ser convertidos para preço. Atualmente essa situação
	 * apenas ocorre nas seguintes mercadorias
	 * </p>
	 * <ul>
	 * <li>- DDI</li>
	 * <li>- DAP</li>
	 * <li>- DDM</li>
	 * <li>- DI1</li>
	 * <li>- DIL</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "ConvsCrit")
	public String conversion_criteria;

	/**
	 * Este campo é utilizado em conjunto com os dois campos anteriores (Base e
	 * Conversão Requerida) para permitir a conversão de taxa para preço,
	 * fornecendo o número de pontos no vencimento para os contratos negociados
	 * em taxa.
	 */
	@Up2DataColumn(name = "MtrtyDtTrgtPt")
	public Integer maturity_tgt_point;

	/**
	 * Indica se um contrato negociado em taxa deve ser convertido para preço.
	 * Atualmente o único contrato em taxa que não precisa ser convertido é o
	 * swap cambial. Este campo não será preenchido nos contratos negociados em
	 * preço.
	 */
	@Up2DataColumn(name = "ReqrdConvsInd")
	public Boolean required_conversion;

	/**
	 * INTERNATIONAL SECURITIES IDENTIFICATION NUMBER –
	 */
	@Up2DataColumn(name = "ISIN")
	public String isin;

	/**
	 * Código usado para classificar um instrumento.
	 */
	@Up2DataColumn(name = "CFICd")
	public String cfi;

	/**
	 * Data de início do aviso de entrega. Um aviso de entrega por escrito pelo
	 * titular da posição vendida em contratos futuros informar a câmara de
	 * compensação da intenção e dos detalhes de entrega de uma mercadoria para
	 * liquidação.
	 */
	@Up2DataColumn(name = "DlvryNtceStartDt", format = "yyyy-MM-dd")
	public Date delivery_start;

	/**
	 * Data final para a entrega física, ou seja, é o prazo limite para entregar
	 * o objeto do contrato.
	 */
	@Up2DataColumn(name = "DlvryNtceEndDt", format = "yyyy-MM-dd")
	public Date delivery_end;

	/**
	 * Tipo de entrega no vencimento. Exemplo: 0 – Physical Delivery 1 –
	 * Financial Este campo requer uma lista de código externo. Esses códigos e
	 * valores foram feitos em planilhas externas para permitir a manutenção de
	 * acordo com os requisitos de atualizações da B3. Neste caso, o externo é
	 * ExternalDeliveryTypeCode no arquivo ExternalCodeLists_BVMF.xls.
	 */
	@Up2DataColumn(name = "DlvryTp")
	public String delivery_type;

	/**
	 * Este atributo identifica a forma de liquidação do negócio. Este campo
	 * requer uma lista de código externo. Esses códigos e valores foram feitos
	 * em planilhas externas para permitir a manutenção de acordo com os
	 * requisitos de atualizações da B3. Neste caso, o externo é
	 * ExternalPaymentTypeCode no arquivo ExternalCodeLists_BVMF.xls.
	 */
	@Up2DataColumn(name = "PmtTp")
	public String payment_type;

	/**
	 * É a razão entre o tamanho do contrato e a quantidade de cotação da
	 * mercadoria. Por exemplo, o contrato futuro de boi (BGI) é composto de 330
	 * arrobas, mas o preço de negociação é baseado em 1 arroba. Logo, para
	 * calcular o valor financeiro de uma operação, é necessário multiplicar o
	 * valor negociado por 330 (multiplicador do contrato). Outro exemplo são os
	 * contratos de dólar, definidos em US$ 50.000, mas cujo preço negociado
	 * refere-se a US$ 1.000. Para contratos negociados em taxa em vez de preço,
	 * este atributo representa a razão entre os pontos no vencimento e o
	 * tamanho do contrato.
	 */
	@Up2DataColumn(name = "CtrctMltplr")
	public Double multiplier;

	/**
	 * Indica a quantidade da mercadoria na qual o preço do negócio é baseado.
	 * Por exemplo, o preço de negócios de boi são baseados em 1 arroba. O preço
	 * de negócios de dólar são baseados em 1.000 dólares; Este atributo é
	 * preenchido com “1”, se o instrumento for negociado em taxa.
	 */
	@Up2DataColumn(name = "AsstQtnQty")
	public Double quotation_qty;

	/**
	 * Tamanho de lote pre-definido para fins de alocação.
	 */
	@Up2DataColumn(name = "AllcnRndLot")
	public Integer lot_round;

	/**
	 * Este atributo possui o código da moeda de negociação. Este campo requer
	 * uma lista de código externo. Esses códigos e valores foram feitos em
	 * planilhas externas para permitir a manutenção flexível de acordo com os
	 * requisitos de atualizações da B3. Neste caso, o externo é
	 * ExternalActiveOrHistoricCurrencyCode no arquivo
	 * ExternalCodeLists_BVMF.xls.
	 */
	@Up2DataColumn(name = "TradgCcy")
	public String currency;

	/**
	 * Tipo de valor do instrumento, por exemplo, preço ou taxa. Exemplos: 0 –
	 * Rate 1 – Price Este campo requer uma lista de código externo. Esses
	 * códigos e valores foram feitos em planilhas externas para permitir a
	 * manutenção de acordo com os requisitos de atualizações da B3. Neste caso,
	 * o externo é ExternalValueTypeCode no arquivo ExternalCodeLists_BVMF.xls
	 */
	@Up2DataColumn(name = "ValTpCd")
	public String value_type;

	/**
	 * Fornece o número de dias de saque, considerando a data do pregão até a
	 * data de vencimento do contrato (inclusive).
	 */
	@Up2DataColumn(name = "WdrwlDays")
	public Integer withdrawal_days;

	/**
	 * Fornece o número de dias úteis, considerando a data do pregão até a data
	 * do vencimento do contrato (inclusive).
	 */
	@Up2DataColumn(name = "WrkgDays")
	public Integer working_days;

	/**
	 * Fornece o número de dias corridos, considerando a data do pregão até a
	 * data do vencimento do contrato (inclusive).
	 */
	@Up2DataColumn(name = "ClnrDays")
	public Integer calendar_days;

	/**
	 * Este campo indica se houve atualização de dados de determinado registro.
	 * Os status validos para o registro são: I = Incluído (a linha não existia
	 * na publicação anterior). Todas as primeiras publicações do dia terão esse
	 * status; U = Atualizado (a linha já existia na publicação anterior e
	 * sofreu uma atualização em qualquer campo); D = Deletado (a linha deve ser
	 * excluída). Será mostrada uma única vez no arquivo divulgado, em seguida
	 * será realizada a exclusão. Se um novo arquivo for gerado após esse
	 * status, a informação não será mais exibida no campo; e N = Nenhum (a
	 * linha já existia na publicação anterior e não sofreu nenhuma atualização
	 * em qualquer campo).
	 */
	@Up2DataColumn(name = "DataSts")
	public String status;
}
