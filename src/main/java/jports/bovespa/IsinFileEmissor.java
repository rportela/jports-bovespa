package jports.bovespa;

import java.util.Date;

import jports.text.CsvColumn;
import jports.text.CsvTable;

/**
 * This class maps to bovespa's EMISSOR file inside the files downloaded from
 * http://www.bmfbovespa.com.br/pt_br/servicos/market-data/consultas/mercado-a-vista/codigo-isin/pesquisa/
 * 
 * @author rportela
 *
 */
@CsvTable(
		charset = "windows-1252",
		capacity = 40000,
		firstRowHasNames = false,
		separator = ",")
public class IsinFileEmissor {

	/**
	 * CODIGO DO EMISSOR - CARACTER 4
	 */
	@CsvColumn(
			position = 0)
	public String codigo;

	/**
	 * NOME DO EMISSOR - CARACTER 70
	 */
	@CsvColumn(
			position = 1)
	public String nome;

	/**
	 * CNPJ DO EMISSOR - CARACTER 14
	 */
	@CsvColumn(
			position = 2)
	public Long cnpj;

	/**
	 * DATA CRIAÇÃO DO EMISSOR - DATA 8
	 */
	@CsvColumn(
			position = 3,
			pattern = "yyyyMMdd")
	public Date data_criacao;
}
