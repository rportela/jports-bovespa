package jports.bovespa;

import java.util.Date;

/**
 * Capital Social é o valor que os sócios ou acionistas estabelecem para sua
 * empresa no momento da abertura. Esta classe contém as informações referentes
 * ao capital social das empresas de capital aberto atualmente listadas na B3.
 * 
 * @author gmarinelli
 *
 */

public class CapitalSocial {
	public String nome_pregao;

	public String codigo;

	public String denom_social;

	public String segmento_mercado;

	public String tipo_de_capital;

	public Double capital;

	public Date aprovado_em;

	public Double qtd_on;

	public Double qtd_pn;

	public Double qtd_total;

	public String classe_1;

	public Double qtd_classe_1;

	public String classe_2;

	public Double qtd_classe_2;

	public String classe_3;

	public Double qtd_classe_3;

	public String classe_4;

	public Double qtd_classe_4;

	public String classe_5;

	public Double qtd_classe_5;

	public String classe_6;

	public Double qtd_classe_6;

	public Date updated_at;
	
	public Date reference_date;

}
