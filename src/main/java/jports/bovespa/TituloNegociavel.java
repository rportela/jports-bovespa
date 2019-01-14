package jports.bovespa;

import java.util.Date;

import jports.adapters.BooleanAsSpecificString;
import jports.adapters.DoubleDiv10000000;
import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

/**
 * 3.3 - REGISTRO - 02 - DADOS DOS TÍTULOS NEGOCIÁVEIS
 * 
 * @author rportela
 *
 */
@FixedLengthTable(
		charset = "windows-1252")
public class TituloNegociavel {

	/**
	 * 02 – CÓDIGO DE NEGOCIAÇÃO DO PAPEL
	 */
	@FixedLengthColumn(
			start = 2,
			end = 14)
	public String ticker;

	/**
	 * 03 – CÓDIGO DA EMPRESA
	 */
	@FixedLengthColumn(
			start = 14,
			end = 18)
	public String empresa_codigo;

	/**
	 * 04 – CÓDIGO BDI
	 */
	@FixedLengthColumn(
			start = 18,
			end = 21)
	public int bdi_id;

	/**
	 * 05 – DESCRIÇÃO DO CODBDI
	 */
	@FixedLengthColumn(
			start = 21,
			end = 81)
	public String bdi_descricao;

	/**
	 * 06 – CÓDIGO ISIN DO PAPEL
	 */
	@FixedLengthColumn(
			start = 81,
			end = 93)
	public String isin;

	/**
	 * 07 – CÓDIGO ISIN DO PAPEL OBJETO
	 */
	@FixedLengthColumn(
			start = 93,
			end = 105)
	public String isin_objeto;

	/**
	 * 08 – NÚMERO DISTRIBUIÇÃO DO PAPEL
	 */
	@FixedLengthColumn(
			start = 105,
			end = 108)
	public int distribuicao;

	/**
	 * 09 – CÓDIGO DO MERCADO
	 */
	@FixedLengthColumn(
			start = 108,
			end = 111)
	public int mercado_id;

	/**
	 * 10 – DESCRIÇÃO DO MERCADO
	 */
	@FixedLengthColumn(
			start = 111,
			end = 126)
	public String mercado_descricao;

	/**
	 * 11 – NÚMERO DE SÉRIE P/ OS MERCADOS DE OPÇÕES, TERMO SECUDÁRIO E FUTURO
	 */
	@FixedLengthColumn(
			start = 126,
			end = 133)
	public int serie;

	/**
	 * 12 – ESPECIFICAÇÃO DO PAPEL OBJETO
	 */
	@FixedLengthColumn(
			start = 133,
			end = 143)
	public String especificacao;

	/**
	 * 13 – DATA DE VENCIMENTO PARA OS MERCADOS DE OPÇÕES DE COMPRA/ VENDA, TERMO
	 * SECUNDÁRIO E FUTURO
	 */
	@FixedLengthColumn(
			start = 143,
			end = 153,
			pattern = "yyyy-MM-dd")
	public Date vencimento;

	/**
	 * 14 – PREÇO - SE MERCADO = 30, VALOR DO CONTRATO; SE MERCADO = 70 OU 80, PREÇO
	 * DE EXERCÍCIO; SE MERCADO = 50, PREÇO DE AJUSTE; CASO CONTRÁRIO CONTERÁ ZEROS
	 */
	@FixedLengthColumn(
			start = 153,
			end = 171,
			adapter = DoubleDiv10000000.class)
	public Double preco_exercicio;

	/**
	 * 15 – ESTILO DA OPÇÃO - PARA MERCADO DE OPÇÕES ‘E’ = EUROPÉIA ‘A’ = AMERICANA
	 * PARA DEMAIS MERCADOS ‘ ‘ = FIXO
	 */
	@FixedLengthColumn(
			start = 171,
			end = 172)
	public String opcao_estilo;

	/**
	 * 16 – INDICADOR DO TIPO DE MOEDA/CORREÇÃO PREÇOS DE EXERCÍCIO DE OPÇÕES DE
	 * COMPRA/VENDA OU VALOR DE CONTRATO PARA O MERCADO DE TERMO SECUNDÁRIO
	 */
	@FixedLengthColumn(
			start = 172,
			end = 175)
	public int indicador_id;

	/**
	 * 17 – DESCRIÇÃO DO INDICADOR DO TIPO DE MOEDA/CORREÇÃO PREÇOS DE EXERCÍCIO DE
	 * OPÇÕES DE COMPRA/VENDA OU VALOR DE CONTRATO PARA O MERCADO DE TERMO
	 * SECUNDÁRIO
	 */
	@FixedLengthColumn(
			start = 175,
			end = 190)
	public String indicador_descricao;

	/**
	 * 18 – PROTEÇÃO
	 */
	@FixedLengthColumn(
			start = 190,
			end = 193,
			adapter = BooleanAsSpecificString.class,
			pattern = "SIM")
	public boolean protegido;
}
