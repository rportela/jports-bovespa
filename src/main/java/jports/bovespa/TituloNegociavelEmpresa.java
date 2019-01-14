package jports.bovespa;

import jports.text.FixedLengthColumn;
import jports.text.FixedLengthTable;

/**
 * Dados de empresa dentro do arquivo de titulos negociáveis da Bovespa.
 * 
 * @author rportela
 *
 */
@FixedLengthTable(
		charset = "windows-1252")
public class TituloNegociavelEmpresa {

	@FixedLengthColumn(
			start = 2,
			end = 6)
	public String codigo;

	@FixedLengthColumn(
			start = 6,
			end = 66)
	public String razao_social;

	@FixedLengthColumn(
			start = 66,
			end = 78)
	public String nome;

}
