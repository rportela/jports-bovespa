package jports.bovespa;

import java.util.Date;

import jports.text.CsvColumn;
import jports.text.CsvTable;

/**
 * A norma ISO 6166 ou ISIN (International Securities Identification Number) foi
 * criada visando a estabelecer uma padronização internacional na codificação de
 * títulos financeiros, atribuindo a cada ativo um código único de
 * identificação.
 * 
 * @author rportela
 *
 */
@CsvTable(
		charset = "windows-1252",
		capacity = 110000,
		firstRowHasNames = false,
		separator = "\",\"")
public class IsinFileTitulo {

	/**
	 * DATA DA GERAÇÃO DO ARQUIVO
	 */
	@CsvColumn(
			pattern = "\"yyyyMMdd")
	public Date data_arquivo;

	/**
	 * AÇÃO SOFRIDA PELA INFORMAÇÃO
	 * 
	 * <ul>
	 * <li>N = Novo</li>
	 * <li>D = Inativado</li>
	 * <li>A = Alterado</li>
	 * </ul>
	 */
	@CsvColumn
	public String acao_sofrida;

	/**
	 * CÓDIGO ISIN - CARACTER(12)
	 */
	@CsvColumn
	public String isin;

	/**
	 * CODIGO EMISSOR - CARACTER(4);
	 */
	@CsvColumn
	public String emissor;

	/**
	 * CODIGO CFI - CARACTER(6);
	 */
	@CsvColumn
	public String cfi;

	/**
	 * DESCRICAO - CARACTER(120)
	 */
	@CsvColumn
	public String descricao;

	/**
	 * ANO EMISSAO
	 */
	@CsvColumn
	public Integer emissao_ano;

	/**
	 * DATA EMISSAO
	 */
	@CsvColumn(
			pattern = "yyyyMMdd")
	public Date emissao_data;

	/**
	 * ANO EXPIRACAO
	 */
	@CsvColumn
	public Integer expiracao_ano;

	/**
	 * DATA EXPIRACAO
	 */
	@CsvColumn(
			pattern = "yyyyMMdd")
	public Date expiracao_data;

	/**
	 * TAXA JUROS - CARACTER(10)
	 */
	@CsvColumn
	public String taxa_juros;

	/**
	 * MOEDAS (BRL = Real;) - CARACTER(3)
	 */
	@CsvColumn
	public String moeda;

	/**
	 * VALOR NOMINAL - NUMERICO(16)
	 */
	@CsvColumn
	public Double valor_nominal;

	/**
	 * PRECO EXERCICIO - NUMERICO(15)
	 */
	@CsvColumn
	public Double preco_exercicio;

	/**
	 * INDEXADOR
	 * 
	 * <ul>
	 * <li>PRE = Taxa Pré-Fixada</li>
	 * <li>DOL = Cupom de Dólar (Dólar Comercial)</li>
	 * <li>TR = Taxa Referencial</li>
	 * <li>SEL = Taxa Selic</li>
	 * <li>ANB = Taxa ANBID</li>
	 * <li>IGPD = Índice Geral de Preços – DI</li>
	 * <li>TMS = Taxa TMS</li>
	 * <li>DI1 = Taxa CDI CETIP</li>
	 * <li>DOF = Cupom de Dólar (Dólar Flutuante)</li>
	 * <li>IGP = Índice Geral de Preços</li>
	 * <li>TBF = Taxa Básica de Juros</li>
	 * <li>TJL = Taxa TJLP</li>
	 * <li>INPC = Taxa INPC</li>
	 * <li>DI F = Contrato Futuro Taxa DI</li>
	 * <li>INCC = Índice Nacional de Custo da Construção</li>
	 * <li>IP = Índice de Poupança</li>
	 * <li>IPC = Índice de Preços ao Consumidor - FIPE</li>
	 * <li>IPCA = Índice Nacional de Preços ao Consumidor Amplo - IBGE</li>
	 * <li>JPY = IENE</li>
	 * </ul>
	 */
	@CsvColumn
	public String indexador;

	/**
	 * PERCENTUAL INDEXADOR - NUMERICO(7)
	 */
	@CsvColumn
	public Double indexador_pct;

	/**
	 * DATA DA AÇÃO;
	 */
	@CsvColumn(
			pattern = "yyyyMMdd")
	public Date data_acao;

	/**
	 * CODIGO CETIP - CARACTER(20)
	 */
	@CsvColumn
	public String cetip_id;

	/**
	 * CODIGO SELIC - CARACTER(6)
	 */
	@CsvColumn
	public String selic_id;

	/**
	 * CÓDIGO PAIS (BR = Brasil) - CARACTER(2)
	 */
	@CsvColumn
	public String pais;

	/**
	 * TIPO DE ATIVO (Veja tabela de tipo de ativo) - CARACTER(3)
	 */
	@CsvColumn
	public String ativo_tipo;

	/**
	 * CODIGO CATEGORIA (Veja tabela de categoria) - CARACTER(2)
	 */
	@CsvColumn
	public String categoria;

	/**
	 * CÓDIGO ESPÉCIE (Veja tabela de espécie) - CARACTER(2)
	 */
	@CsvColumn
	public String especia;

	/**
	 * DATA BASE - DATA(8)
	 */
	@CsvColumn(
			pattern = "yyyyMMdd")
	public Date data_base;

	/**
	 * NÚMERO DE EMISSÃO - CARACTER(2)
	 */
	@CsvColumn
	public String emissao_numero;

	/**
	 * NUMERO DE SÉRIE- CARACTER(2)
	 */
	@CsvColumn
	public String serie;

	/**
	 * TIPO DE EMISSÃO
	 * 
	 * <ul>
	 * <li>D = DOMESTICA (DELFAULT)</li>
	 * <li>I = INTERNACIONAL</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String emissao_tipo;

	/**
	 * TIPO ATIVO OBJETO
	 * 
	 * <ul>
	 * <li>S=AÇÃO/RENDA VARIÁVEL</li>
	 * <li>D=RENDA FIXA</li>
	 * <li>T=COMMODITIES</li>
	 * <li>I=ÍNDICES</li>
	 * <li>F=FUTURO</li>
	 * <li>B=CESTA</li>
	 * <li>N=TAXA DE JUROS</li>
	 * <li>C=MOEDA</li>
	 * <li>O=OPÇÃO</li>
	 * <li>W=SWAP</li>
	 * <li>M=OUTROS</li>
	 * </ul>
	 * <p>
	 * CARACTER(1)
	 * </p>
	 */
	@CsvColumn
	public String objeto_tipo;

	/**
	 * TIPO DE ENTREGA
	 * 
	 * <ul>
	 * <li>P = FÍSICA</li>
	 * <li>C = FINANCEIRA</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String entrega_tipo;

	/**
	 * TIPO DE FUNDO
	 * 
	 * <ul>
	 * <li>C = Fechado</li>
	 * <li>O = Aberto</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String fundo_tipoi;

	/**
	 * TIPO DE GARANTIA
	 * 
	 * <ul>
	 * <li>T = GARANTIDO PELO TESOURO</li>
	 * <li>G = GARANTIA P/ TERCEIROS (FIANÇA)</li>
	 * <li>S = GARANTIA REAL</li>
	 * <li>UF = FLUTUANTE</li>
	 * <li>US = SUBORDINADA</li>
	 * <li>UQ = QUIROGRAFÁRIA</li>
	 * </ul>
	 * 
	 * CARACTER(2)
	 */
	@CsvColumn
	public String garantia;

	/**
	 * TIPO DE JUROS
	 * 
	 * <ul>
	 * <li>Z = ZERO (TAXA DE DESCONTO)</li>
	 * <li>F = FIXO</li>
	 * <li>V = VARIÁVEL (DEFAULT)</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String juros_tipo;

	/**
	 * TIPO DE MERCADO
	 * 
	 * <ul>
	 * <li>S = PADRONIZADA</li>
	 * <li>N = NÃO PADRONIZADA</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String mercado_tipo;

	/**
	 * TIPO STATUS ISIN
	 * 
	 * <ul>
	 * <li>N = ISIN NOVO</li>
	 * <li>R = ISIN REUTILIZADO</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String isin_status;

	/**
	 * TIPO DE VENCIMENTO
	 * 
	 * <ul>
	 * <li>A = PLANO DE AMORTIZAÇÃO</li>
	 * <li>B = PLANO AMORTIZAÇÃO C/ RESGATE ANTECIPADO</li>
	 * <li>Q = PERPETUO COM OPÇÃO DE RESGATE</li>
	 * <li>P = PERPETUO</li>
	 * <li>F = VENCIMENTO FIXO</li>
	 * <li>G = RESGATE ANTECIPADO</li>
	 * </ul>
	 * 
	 * CARACTER (1)
	 */
	@CsvColumn
	public String vencimento_tipo;

	/**
	 * TIPO DE PROTEÇÃO
	 * 
	 * <ul>
	 * <li>S = PROTEGIDO</li>
	 * <li>N = DESPROTEGIDO</li>
	 * </ul>
	 * 
	 * CARACTER (1)
	 */
	@CsvColumn
	public String protecao_tipo;

	/**
	 * TIPO POLITICA DISTRIBUIÇÃO FUNDOS
	 * 
	 * <ul>
	 * <li>I = Fundo de Renda</li>
	 * <li>G = Fundo de Crescimento</li>
	 * <li>M = Fundo Misto</li>
	 * </ul>
	 * CARACTER(1)
	 */
	@CsvColumn
	public String politica_distrbuicao_fundo;

	/**
	 * TIPO ATIVOS INVESTIDOS PELO FUNDO
	 * 
	 * <ul>
	 * <li>R = Fundo de Investimento Imobiliário</li>
	 * <li>S = Fundo de Investimento em Títulos e Valores Mobiliários e Instrumentos
	 * Financeiros</li>
	 * <li>M = Fundo de Investimentos em Ativos Diferentes - Misto</li>
	 * <li>C = Fundo de Investimentos em Commodities</li>
	 * <li>D = Fundo de Investimentos em Derivativos</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String ativos_investidos_fundo;

	@CsvColumn
	public String forma;

	/**
	 * TIPO ESTILO OPÇÃO
	 * 
	 * <ul>
	 * <li>A = AMERICANA</li>
	 * <li>E = EUROPÉIA</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String opcao_estilo;

	/**
	 * NÚMERO DE SÉRIE DE OPÇÃO - CARACTER(4)
	 */
	@CsvColumn
	public String opcao_serie;

	/**
	 * CÓDIGO FREQUENCIA DE JUROS
	 * 
	 * <ul>
	 * <li>A = ANUAL</li>
	 * <li>B = BI-ANUAL</li>
	 * <li>M = MENSAL</li>
	 * <li>Q = TRIMESTRAL</li>
	 * <li>S = SEMESTRAL</li>
	 * <li>W = SEMANAL</li>
	 * <li>X = OUTROS</li>
	 * </ul>
	 * 
	 * <p>
	 * CARACTER(1)
	 * </p>
	 */
	@CsvColumn
	public String frequencia_juros;

	/**
	 * SITUAÇÃO ISIN
	 * 
	 * <ul>
	 * <li>A = ATIVO (DEFAULT)</li>
	 * <li>I = INATIVO</li>
	 * </ul>
	 * 
	 * CARACTER(1)
	 */
	@CsvColumn
	public String isin_situacao;

	/**
	 * DATA DO PRIMEIRO PAGAMENTO DE JUROS - DATA(8)
	 */
	@CsvColumn
	public String primeiro_pagamento_juros;

}
