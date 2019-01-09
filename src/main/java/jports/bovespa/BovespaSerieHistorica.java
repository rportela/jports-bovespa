package jports.bovespa;

import java.util.Date;

import jports.adapters.DoubleDiv100;
import jports.adapters.DoubleDiv1000000;
import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

/**
 * Informações das cotações históricas relativas à negociação de todos os
 * papéis-mercado no período
 * 
 * @author rportela
 *
 */
@FixedLengthTable(
		charset = "windows-1252")
public class BovespaSerieHistorica {

	@FixedLengthColumn(
			start = 2,
			end = 10,
			pattern = "yyyyMMdd")
	public Date data_pregao;

	/**
	 * UTILIZADO PARA CLASSIFICAR OS PAPÉIS NA EMISSÃO DO BOLETIM DIÁRIO DE
	 * INFORMAÇÕES
	 */
	@FixedLengthColumn(
			start = 10,
			end = 12)
	public int bdi;

	/**
	 * CODNEG - CÓDIGO DE NEGOCIAÇÃO DO PAPEL
	 */
	@FixedLengthColumn(
			start = 12,
			end = 24)
	public String ticker;

	/**
	 * CÓD. DO MERCADO EM QUE O PAPEL ESTÁ CADASTRADO VER TABELA ANEXA
	 */
	@FixedLengthColumn(
			start = 24,
			end = 27)
	public int mercado_id;

	/**
	 * NOME RESUMIDO DA EMPRESA EMISSORA DO PAPEL
	 */
	@FixedLengthColumn(
			start = 27,
			end = 39)
	public String empresa;

	/**
	 * ESPECIFICAÇÃO DO PAPEL - VER TABELA ANEXA
	 */
	@FixedLengthColumn(
			start = 39,
			end = 49)
	public String especificacao;

	/**
	 * PRAZO EM DIAS DO MERCADO A TERMO
	 */
	@FixedLengthColumn(
			start = 49,
			end = 52)
	public int prazo_termo;

	/**
	 * MOEDA USADA NA DATA DO PREGÃO
	 */
	@FixedLengthColumn(
			start = 52,
			end = 56)
	public String moeda;

	/**
	 * PREÇO DE ABERTURA DO PAPEL-MERCADO NO PREGÃO
	 */
	@FixedLengthColumn(
			start = 56,
			end = 69,
			adapter = DoubleDiv100.class)
	public double preco_abertura;

	/**
	 * PREÇO MÁXIMO DO PAPEL-MERCADO NO PREGÃO
	 */
	@FixedLengthColumn(
			start = 69,
			end = 82,
			adapter = DoubleDiv100.class)
	public double preco_maximo;

	/**
	 * PREÇO MÍNIMO DO PAPEL- MERCADO NO PREGÃO
	 */
	@FixedLengthColumn(
			start = 82,
			end = 95,
			adapter = DoubleDiv100.class)
	public double preco_minimo;

	/**
	 * PREÇO MÉDIO DO PAPEL- MERCADO NO PREGÃO
	 */
	@FixedLengthColumn(
			start = 95,
			end = 108,
			adapter = DoubleDiv100.class)
	public double preco_medio;

	/**
	 * PREÇO DO ÚLTIMO NEGÓCIO DO PAPEL-MERCADO NO PREGÃO
	 */
	@FixedLengthColumn(
			start = 108,
			end = 121,
			adapter = DoubleDiv100.class)
	public double preco_ultimo;

	/**
	 * PREÇO DA MELHOR OFERTA DE COMPRA DO PAPEL-MERCADO
	 */
	@FixedLengthColumn(
			start = 121,
			end = 134,
			adapter = DoubleDiv100.class)
	public double preco_melhor_compra;

	/**
	 * PREÇO DA MELHOR OFERTA DE VENDA DO PAPEL-MERCADO
	 */
	@FixedLengthColumn(
			start = 134,
			end = 147,
			adapter = DoubleDiv100.class)
	public double preco_melhor_venda;

	/**
	 * NÚMERO DE NEGÓCIOS EFETUADOS COM O PAPEL- MERCADO NO PREGÃO
	 */
	@FixedLengthColumn(
			start = 147,
			end = 152)
	public int quantidade_negocios;

	/**
	 * QUANTIDADE TOTAL DE TÍTULOS NEGOCIADOS NESTE PAPEL- MERCADO
	 */
	@FixedLengthColumn(
			start = 152,
			end = 170)
	public long quantidade_titulos;

	/**
	 * VOLUME TOTAL DE TÍTULOS NEGOCIADOS NESTE PAPEL- MERCADO
	 */
	@FixedLengthColumn(
			start = 170,
			end = 188,
			adapter = DoubleDiv100.class)
	public double volume_titulos;

	/**
	 * PREÇO DE EXERCÍCIO PARA O MERCADO DE OPÇÕES OU VALOR DO CONTRATO PARA O
	 * MERCADO DE TERMO SECUNDÁRIO
	 */
	@FixedLengthColumn(
			start = 188,
			end = 201,
			adapter = DoubleDiv100.class)
	public double preco_exercicio;

	/**
	 * INDICADOR DE CORREÇÃO DE PREÇOS DE EXERCÍCIOS OU VALORES DE CONTRATO PARA OS
	 * MERCADOS DE OPÇÕES OU TERMO SECUNDÁRIO
	 */
	@FixedLengthColumn(
			start = 201,
			end = 202)
	public int indicador_id;

	/**
	 * DATA DO VENCIMENTO PARA OS MERCADOS DE OPÇÕES OU TERMO SECUNDÁRIO
	 */
	@FixedLengthColumn(
			start = 202,
			end = 210,
			pattern = "yyyyMMdd")
	public Date data_vencimento;

	/**
	 * FATOR DE COTAÇÃO DO PAPEL
	 */
	@FixedLengthColumn(
			start = 210,
			end = 217)
	public int lote;

	/**
	 * 
	 * PREÇO DE EXERCÍCIO EM PONTOS PARA OPÇÕES REFERENCIADAS EM DÓLAR OU VALOR DE
	 * CONTRATO EM PONTOS PARA TERMO SECUNDÁRIO.
	 * 
	 * <p>
	 * PARA OS REFERENCIADOS EM DÓLAR, CADA PONTO EQUIVALE AO VALOR, NA MOEDA
	 * CORRENTE, DE UM CENTÉSIMO DA TAXA MÉDIA DO DÓLAR COMERCIAL INTERBANCÁRIO DE
	 * FECHAMENTO DO DIA ANTERIOR, OU SEJA, 1 PONTO = 1/100 US$
	 * </p>
	 */
	@FixedLengthColumn(
			start = 217,
			end = 230,
			adapter = DoubleDiv1000000.class)
	public double pontos_exercicio;

	/**
	 * CÓDIGO DO PAPEL NO SISTEMA ISIN A PARTIR DE 15-05-1995
	 */
	@FixedLengthColumn(
			start = 230,
			end = 242)
	public String isin;

	/**
	 * NÚMERO DE SEQÜÊNCIA DO PAPEL CORRESPONDENTE AO ESTADO DE DIREITO VIGENTE
	 */
	@FixedLengthColumn(
			start = 242,
			end = 245)
	public int distribuicao;
}
