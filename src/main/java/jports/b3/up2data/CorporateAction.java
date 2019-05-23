package jports.b3.up2data;

import java.util.Date;

/**
 * UP2DATA – PortfolioComposition
 * 
 * Corporate Actions of the day (ex-date is the next day).
 * 
 * @author Giovanna Marinelli
 *
 */

@Up2DataTable(channel = "Corporate_Action", subChannel = "CorporateAction", prefix = "Corporate_Action_CorporateActionFile_")
public class CorporateAction {

	/**
	 * Data de referência da informação.
	 */
	@Up2DataColumn(name = "RptDt", format = "yyyy-MM-dd")
	public Date report_date;

	/**
	 * Identificador único associado ao evento
	 */
	@Up2DataColumn(name = "CorpActnId")
	public String id;

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
	 * Indicador ou classe do ativo. O valor válido para este campo é “8”.
	 */
	@Up2DataColumn(name = "SctySrc")
	public String security_src;

	/**
	 * Código identificador da bolsa em que o instrumento está listado.
	 * Identificação do mercado financeiro, conforme estipulado na norma ISO
	 * 10383 . Default = “BVMF”.
	 */
	@Up2DataColumn(name = "MktIdrCd")
	public String market_cd;

	/**
	 * Mercadoria associada ao instrumento. Exemplos: DOL, BGI, OZ1, WDL, CNI,
	 * ICF, CCM, etc.
	 */
	@Up2DataColumn(name = "Asst")
	public String asset;

	/**
	 * Descrição da mercadoria
	 */
	@Up2DataColumn(name = "AsstDesc")
	public String asset_descr;

	/**
	 * <p>
	 * Um Segmento representa o primeiro nível de classificação de mercado no
	 * processo de pós-negociação.
	 * </p>
	 * <p>
	 * Domínio:
	 * </p>
	 * <ul>
	 * <li>EQUITY-CASH</li>
	 * <li>EQUITY-DERIVATE</li>
	 * <li>FIXED INCOME</li>
	 * <li>AGRIBUSINESS</li>
	 * <li>FINANCIAL</li>
	 * <li>METAL</li>
	 * <li>ENERGY</li>
	 * <li>GOV. BONDS</li>
	 * <li>FX</li>
	 * <li>OTC</li>
	 * <li>INDICATORS</li>
	 * <li>OTC traded Securities Lending</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "SgmtNm")
	public String segment;

	/**
	 * <p>
	 * Um Mercado representa o segundo nível de classificação de mercado no
	 * processo de pós-negociação.
	 * </p>
	 * <p>
	 * Domínio:
	 * </p>
	 * 
	 * <ul>
	 * <li>Spot</li>
	 * <li>Future</li>
	 * <li>Options on Spot</li>
	 * <li>Options on Future</li>
	 * <li>Forward</li>
	 * <li>Cash</li>
	 * <li>Options exercise (call)</li>
	 * <li>Options exercise (put)</li>
	 * <li>Auction</li>
	 * <li>Odd Lot</li>
	 * <li>Equity Forward</li>
	 * <li>Equity Call</li>
	 * <li>Equity Put</li>
	 * <li>Swap</li>
	 * <li>Flexible Put Option</li>
	 * <li>Flexible Put Option</li>
	 * <li>Forward</li>
	 * <li>Indicators</li>
	 * <li>Curves</li>
	 * <li>Surfaces</li>
	 * <li>Security Lending OTC</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "MktNm")
	public String market;

	/**
	 * Descrição do instrumento geralmente formada pelo nome da empresa e tipo
	 * do papel.
	 */
	@Up2DataColumn(name = "Desc")
	public String descr;

	/**
	 * Código de especificação das ações: ON, PN, e assim por diante.
	 */
	@Up2DataColumn(name = "SpcfctnCd")
	public String specification;

	/**
	 * Representa o terceiro nível de classificação de mercado no processo de
	 * pós-negociação.
	 */
	@Up2DataColumn(name = "SctyCtgyNm")
	public String security_category;

	/**
	 * Data de início da negociação do instrumento financeiro.
	 */
	@Up2DataColumn(name = "TradgStartDt", format = "yyyy-MM-dd")
	public Date trade_start;

	/**
	 * Data da conclusão da negociação do instrumento financeiro.
	 */
	@Up2DataColumn(name = "TradgEndDt", format = "yyyy-MM-dd")
	public Date trade_end;

	/**
	 * Este campo possui o nome da instituição.
	 */
	@Up2DataColumn(name = "CrpnNm")
	public String company;

	/**
	 * Número do Processo do Evento Corporativo, identificador lógico único no
	 * Radar.
	 */
	@Up2DataColumn(name = "PrcCd")
	public int process_id;

	/**
	 * Data Assembléia Divulgação Evento Custódia
	 */
	@Up2DataColumn(name = "CrtApprvlDt", format = "yyyy-MM-dd")
	public Date approved_at;

	/**
	 * <p>
	 * Código do Tipo de Evento Corporativo Dominio:
	 * </p>
	 * 
	 * <ul>
	 * <li>10 - DIVIDENDO</li>
	 * <li>11 - RESTITUIÇÃO DE CAPITAL</li>
	 * <li>12 - BONIFICAÇÃO EM DINHEIRO</li>
	 * <li>13 - JUROS SOBRE CAPITAL PRÓPRIO</li>
	 * <li>14 - RENDIMENTO</li>
	 * <li>16 - JUROS</li>
	 * <li>17 - AMORTIZAÇÃO</li>
	 * <li>18 - PREMIO</li>
	 * <li>19 - ATUALIZAÇÃO MONETÁRIA</li>
	 * <li>20 - BONIFICAÇÃO EM ATIVOS</li>
	 * <li>21 - RESTITUIÇÃO CAPITAL EM AÇÕES</li>
	 * <li>22 - RESTITUIÇÃO CAPITALCOM REDUÇÃO DO NÚMERO DE AÇÕES</li>
	 * <li>30 - DESDOBRAMENTO DE AÇÕES</li>
	 * <li>40 - GRUPAMENTO</li>
	 * <li>50 - SUBSCRIÇÃO</li>
	 * <li>51 - PRIORIDADE DE SUBSCRICAO</li>
	 * <li>52 - EXERCICIO DE SUBSCRICAO</li>
	 * <li>53 - SUBSCRICAO COM RENUNCIA DO DIREITO DE PREFERENCIA</li>
	 * <li>60 - INCORPORAÇÃO</li>
	 * <li>70 - FUSÃO</li>
	 * <li>71 - CANCELAMENTO DE FRAÇÕES</li>
	 * <li>72 - LEILÃO DE FRAÇÕES</li>
	 * <li>73 - DOAÇÃO DE FRAÇÕES</li>
	 * <li>74 - ADMINISTRAÇÃO DE FRAÇÕES</li>
	 * <li>75 - COMPRA DE FRAÇÕES</li>
	 * <li>76 - VENDA DE FRAÇÕES</li>
	 * <li>80 - CISÃO COM RED. DE CAPITAL</li>
	 * <li>81 - CISÃO COM RED. DE CAPITAL E QTDE</li>
	 * <li>90 - ATUALIZACAO</li>
	 * <li>91 - EVENTO COM MÚLTIPLOS REQUISITOS E RESULTADOS</li>
	 * <li>93 - RESGATE PARCIAL RENDA FIXA</li>
	 * <li>94 - RESGATE RENDA FIXA</li>
	 * <li>95 - CONVERSÃO DE ATIVOS</li>
	 * <li>96 - DISSIDÊNCIA</li>
	 * <li>97 - RESGATE RENDA VARIÁVEL</li>
	 * <li>98 - RENDIMENTO LÍQUIDO</li>
	 * <li>99 - SOBRAS DE SUBSCRIÇÃO</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "CorpActnTpCd")
	public int type_id;

	/**
	 * <p>
	 * Descrição do Tipo de Evento Corporativo
	 * </p>
	 * 
	 * <ul>
	 * <li>10 - DIVIDENDO</li>
	 * <li>11 - RESTITUIÇÃO DE CAPITAL</li>
	 * <li>12 - BONIFICAÇÃO EM DINHEIRO</li>
	 * <li>13 - JUROS SOBRE CAPITAL PRÓPRIO</li>
	 * <li>14 - RENDIMENTO</li>
	 * <li>16 - JUROS</li>
	 * <li>17 - AMORTIZAÇÃO</li>
	 * <li>18 - PREMIO</li>
	 * <li>19 - ATUALIZAÇÃO MONETÁRIA</li>
	 * <li>20 - BONIFICAÇÃO EM ATIVOS</li>
	 * <li>21 - RESTITUIÇÃO CAPITAL EM AÇÕES</li>
	 * <li>22 - RESTITUIÇÃO CAPITALCOM REDUÇÃO DO NÚMERO DE AÇÕES</li>
	 * <li>30 - DESDOBRAMENTO DE AÇÕES</li>
	 * <li>40 - GRUPAMENTO</li>
	 * <li>50 - SUBSCRIÇÃO</li>
	 * <li>51 - PRIORIDADE DE SUBSCRICAO</li>
	 * <li>52 - EXERCICIO DE SUBSCRICAO</li>
	 * <li>53 - SUBSCRICAO COM RENUNCIA DO DIREITO DE PREFERENCIA</li>
	 * <li>60 - INCORPORAÇÃO</li>
	 * <li>70 - FUSÃO</li>
	 * <li>71 - CANCELAMENTO DE FRAÇÕES</li>
	 * <li>72 - LEILÃO DE FRAÇÕES</li>
	 * <li>73 - DOAÇÃO DE FRAÇÕES</li>
	 * <li>74 - ADMINISTRAÇÃO DE FRAÇÕES</li>
	 * <li>75 - COMPRA DE FRAÇÕES</li>
	 * <li>76 - VENDA DE FRAÇÕES</li>
	 * <li>80 - CISÃO COM RED. DE CAPITAL</li>
	 * <li>81 - CISÃO COM RED. DE CAPITAL E QTDE</li>
	 * <li>90 - ATUALIZACAO</li>
	 * <li>91 - EVENTO COM MÚLTIPLOS REQUISITOS E RESULTADOS</li>
	 * <li>93 - RESGATE PARCIAL RENDA FIXA</li>
	 * <li>94 - RESGATE RENDA FIXA</li>
	 * <li>95 - CONVERSÃO DE ATIVOS</li>
	 * <li>96 - DISSIDÊNCIA</li>
	 * <li>97 - RESGATE RENDA VARIÁVEL</li>
	 * <li>98 - RENDIMENTO LÍQUIDO</li>
	 * <li>99 - SOBRAS DE SUBSCRIÇÃO</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "CorpActnTpDesc")
	public String type;

	/**
	 * <p>
	 * INTERNATIONAL SECURITIES IDENTIFICATION NUMBER - É uma padronização
	 * internacional na codificação de títulos financeiros, atribuindo a cada
	 * ativo um código único de identificação. O código para os títulos e
	 * valores mobiliários brasileiros apresenta a estrutura BR AAAA BBB CC 7
	 * onde:
	 * </p>
	 * <p>
	 * a) os dois primeiros caracteres (BR) identificam o código do BRASIL.
	 * </p>
	 * <p>
	 * b) os quatro caracteres (AAAA) são alfanuméricos e identificam o emissor.
	 * </p>
	 * <p>
	 * c) os três caracteres (BBB) são alfanuméricos e identificam o tipo de
	 * ativo, podendo ter seqüência automática na segunda posição (Seqüência 1)
	 * e na terceira posição (Seqüência 2) ou não ter qualquer seqüência.
	 * </p>
	 * <p>
	 * d) os dois caracteres (CC) são alfanuméricos e identificam a espécie,
	 * quando se tratar de ações, ou representam uma seqüência automática, para
	 * identificar cada emissão de título e valor mobiliário, quando se tratar
	 * de outras categorias.
	 * </p>
	 * <p>
	 * e) o último caracter (7) é o dígito de controle
	 * </p>
	 */
	@Up2DataColumn(name = "ISINOrgn")
	public String isin_origin;

	/**
	 * <p>
	 * Número que identifica a versão do ativo.
	 * </p>
	 * <p>
	 * Quando houver um evento corporativo de custódia, troca de símbolo ou
	 * qualquer outra variação no ativo, outro código de distribuição será
	 * gerado.
	 * </p>
	 * <p>
	 * O par "Código ISIN" + "Código de Distribuição" é necessário para o ativo
	 * no Depositário Central.
	 * </p>
	 * <p>
	 * A Central Depositária da BM & FBOVESPA gerencia os Eventos Corporativos.
	 * </p>
	 */
	@Up2DataColumn(name = "OrgnDstrbtnCd")
	public Integer distribution_origin;

	/**
	 * <p>
	 * INTERNATIONAL SECURITIES IDENTIFICATION NUMBER - É uma padronização
	 * internacional na codificação de títulos financeiros, atribuindo a cada
	 * ativo um código único de identificação. O código para os títulos e
	 * valores mobiliários brasileiros apresenta a estrutura BR AAAA BBB CC 7
	 * onde:
	 * </p>
	 * <p>
	 * a) os dois primeiros caracteres (BR) identificam o código do BRASIL.
	 * </p>
	 * <p>
	 * b) os quatro caracteres (AAAA) são alfanuméricos e identificam o emissor.
	 * </p>
	 * <p>
	 * c) os três caracteres (BBB) são alfanuméricos e identificam o tipo de
	 * ativo, podendo ter seqüência automática na segunda posição (Seqüência 1)
	 * e na terceira posição (Seqüência 2) ou não ter qualquer seqüência.
	 * </p>
	 * <p>
	 * d) os dois caracteres (CC) são alfanuméricos e identificam a espécie,
	 * quando se tratar de ações, ou representam uma seqüência automática, para
	 * identificar cada emissão de título e valor mobiliário, quando se tratar
	 * de outras categorias.
	 * </p>
	 * <p>
	 * e) o último caracter (7) é o dígito de controle
	 * </p>
	 */
	@Up2DataColumn(name = "ISINPdct")
	public String isin_product;

	/**
	 * <p>
	 * Distribuição Destino do Papel (Distribuição do saldo remanecente após o
	 * evento, utilizado principalmente para eventos em dinheiro, quando
	 * preenchido geralmente é o mesmo do Origem + 1)
	 * </p>
	 */
	@Up2DataColumn(name = "DstrbtnPdct")
	public Integer distribution_product;

	/**
	 * <p>
	 * ISIN Destino do papel
	 * </p>
	 */
	@Up2DataColumn(name = "ISINDstn")
	public String isin_dest;

	/**
	 * <p>
	 * Distribuição Destino do Papel (Distribuição do saldo remanecente após o
	 * evento, utilizado principalmente para eventos em dinheiro, quando
	 * preenchido geralmente é o mesmo do Origem + 1)
	 * </p>
	 */
	@Up2DataColumn(name = "DstrbtnDstn")
	public Integer distribution_dest;

	/**
	 * <p>
	 * A data ex-dividendo é o dia em que as ações compradas e vendidas não têm
	 * direito a receber o dividendo declarado recentemente (negociação de papel
	 * sem o direito).
	 * </p>
	 * <p>
	 * Quando uma empresa declara um dividendo, define uma data de registro em
	 * que os acionistas investidores podem receber dividendos. Depois que a
	 * empresa define essa data de registro, as bolsas de valores fixam a data
	 * ex-dividendo.
	 * </p>
	 * <p>
	 * A data ex-dividendo é geralmente dois dias úteis antes da data de
	 * registro. Se os investidores comprarem uma ação na data ou após a data do
	 * dividendo, não receberão o próximo pagamento de dividendos. Em vez disso,
	 * o fornecedor recebe o dividendo. Se o investidor comprar antes da data
	 * ex-dividendo receberá o dividendo.
	 * <p>
	 * Uma ação ex-dividendo é identificada com um X.
	 * </p>
	 * <p>
	 * Exemplo:
	 * </p>
	 * <p>
	 * Em 27 de julho de 2013, a Companhia XYZ declara um dividendo a ser pago
	 * aos acionistas em 10 de setembro de 2013. A XYZ também anuncia e registra
	 * que os acionistas têm direito a dividendos antes, em 10 de agosto de
	 * 2013. A bolsa de valores fixa, em seguida, o dividendo dois dias úteis
	 * antes da data de registro, em 06 de agosto de 2013.
	 * </p>
	 */
	@Up2DataColumn(name = "SpclExDt", format = "yyyy-MM-dd")
	public Date ex_date;

	/**
	 * Data de Atualização (Data que o evento é atualizado na custódia) Essa
	 * data é utilizada por sistemas que acompanham a custódia, em renda
	 * variável, atualizam a posição em D+3.
	 */
	@Up2DataColumn(name = "UpdDt", format = "yyyy-MM-dd")
	public Date updated_at;

	/**
	 * Data de pagamento da Parcela do Provento em dinheiro ou ativo, previsto
	 * ou efetivado.
	 */
	@Up2DataColumn(name = "PmtDt", format = "yyyy-MM-dd")
	public Date payment_date;

	/**
	 * <p>
	 * Este atributo possui o código da moeda de negociação.
	 * </p>
	 * <p>
	 * Domínio: BRL - REAL USD - DOLAR DOS EUA ARS - PESO (ARGENTINA)
	 * </p>
	 */
	@Up2DataColumn(name = "TradgCcy")
	public String currency;

	/**
	 * Valor do Evento Corporativo, este valor pode estar expresso em fator ou
	 * em dinheiro. Para eventos em dinheiro, este campo trará valor monetário
	 * Para eventos em ativo/voluntário esse campo trará um fator
	 */
	@Up2DataColumn(name = "EvtVal")
	public Double value;

	/**
	 * Número de Parcelas para Pagamento
	 */
	@Up2DataColumn(name = "PmtInstlmtQty")
	public Integer installment_qty;

	/**
	 * Data início da subscrição
	 */
	@Up2DataColumn(name = "SbcptInitlDt", format = "yyyy-MM-dd")
	public Date subscription_start;

	/**
	 * Data fim da subscrição
	 */
	@Up2DataColumn(name = "SbcptFnlDt", format = "yyyy-MM-dd")
	public Date subscription_end;

	/**
	 * Data limite para cessão de direitos de subscrição
	 */
	@Up2DataColumn(name = "SbcptAssgnmtDdln", format = "yyyy-MM-dd")
	public Date subscription_assignment;

	/**
	 * Data limite de fechamento do processo de subscrição na S/A
	 */
	@Up2DataColumn(name = "SASbcptClsgDt", format = "yyyy-MM-dd")
	public Date subscription_closing;

	/**
	 * ISIN do papel Requisito do Evento Corporativo Voluntário que possui saldo
	 * na depositária
	 */
	@Up2DataColumn(name = "ISINRqst")
	public String isin_requisite;

	/**
	 * Número de Distribuição do papel Requisito do Evento Corporativo
	 * Voluntário que possui saldo na depositária(Distribuição do que recebe o
	 * valor do evento, em dinheiro ou ativo)
	 */
	@Up2DataColumn(name = "DstrbtnRqst")
	public Integer description_requisite;

	/**
	 * Fator que determina a quantidade base como Requisito que será utilizada
	 * para compor o cálculo do saldo base do evento corporativo
	 */
	@Up2DataColumn(name = "RqstFctr")
	public Double requisite_factor;

	/**
	 * Preço de Emissão do Papel em Subscrição
	 */
	@Up2DataColumn(name = "RqstVal")
	public Double requisite_value;

	/**
	 * ISIN do papel Resultado do Evento Corporativo Voluntário que possui saldo
	 * na depositária
	 */
	@Up2DataColumn(name = "ISINRslt")
	public String isin_result;

	/**
	 * Número que identifica a versão do ativo. Quando houver um evento
	 * corporativo de custódia, troca de símbolo ou qualquer outra variação no
	 * ativo, outro código de distribuição será gerado. O par "Código ISIN" +
	 * "Código de Distribuição" é necessário para o ativo no Depositário
	 * Central. A Central Depositária da BM & FBOVESPA gerencia os Eventos
	 * Corporativos.
	 */
	@Up2DataColumn(name = "DstrbtnRslt")
	public Integer description_result;

	/**
	 * Fator que determina a quantidade base como Resultado que será utilizada
	 * para compor o cálculo do saldo base do evento corporativo.
	 */
	@Up2DataColumn(name = "RsltFctr")
	public Double result_factor;

	/**
	 * Valor do direito como resultado.
	 */
	@Up2DataColumn(name = "RsltVal")
	public Double result_value;

	/**
	 * <p>
	 * Código que identifica o tipo de parcelamento do pagamento do evento
	 * corporativo
	 * </p>
	 * <p>
	 * Domínio:
	 * </p>
	 * <ul>
	 * <li>0. Bruto</li>
	 * <li>1. Líquido</li>
	 * <li>2. Quantidade</li>
	 * <li>3. Frações</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "InstlmtFlgTpCd")
	public Integer installment;

	/**
	 * <p>
	 * Código da classe do evento corporativo
	 * </p>
	 * <p>
	 * Domínio:
	 * </p>
	 * <ul>
	 * <li>1 - Eventos Tipo A (Altera distribuição)</li>
	 * <li>2 - Eventos Tipo B (Altera ou não distribuição)</li>
	 * <li>3 - Eventos Tipo C (Não altera distribuição)</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "ActnClssCd")
	public Integer event_class;

	/**
	 * Preço de fechamento do papel no último pregão em que houve negociação
	 */
	@Up2DataColumn(name = "TradLastPric")
	public Double last_price;

	/**
	 * Preço de fechamento do papel no último pregão
	 */
	@Up2DataColumn(name = "TradClsgPric")
	public Double closing_price;

	/**
	 * <p>
	 * Código de tipo de ação sobre o evento corporativo de custódia
	 * </p>
	 * <p>
	 * Domínio:
	 * </p>
	 * <ul>
	 * <li>A - Alteração de Eventos</li>
	 * <li>B - Cancelamento de Eventos (C - Eventos Creditados, por isso B é
	 * cancelamento))</li>
	 * <li>I - Inclusão de Eventos</li> *
	 * <li>P - Parcelamento de Eventos</li>
	 * </ul>
	 */
	@Up2DataColumn(name = "EvtActnTpCd")
	public String action;

	/**
	 * <p>
	 * Este campo indica se houve atualização de dados de determinado registro.
	 * Os status validos para o registro são:
	 * </p>
	 * <p>
	 * I = Incluído (a linha não existia na publicação anterior). Todas as
	 * primeiras publicações do dia terão esse status;
	 * </p>
	 * <p>
	 * U = Atualizado (a linha já existia na publicação anterior e sofreu uma
	 * atualização em qualquer campo);
	 * </p>
	 * <p>
	 * D = Deletado (a linha deve ser excluída). Será mostrada uma única vez, no
	 * arquivo divulgado em seguida será realizada a exclusão. Se um novo
	 * arquivo for gerado após esse status, a informação não será mais exibida
	 * no campo; e
	 * </p>
	 * <p>
	 * N = Nenhum (a linha já existia na publicação anterior e não sofreu
	 * nenhuma atualização em qualquer campo).
	 * </p>
	 */
	@Up2DataColumn(name = "DataSts")
	public String status;
}
