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

public class BovespaCapitalSocial {
	public String nome_pregao;

	public String codigo;

	public String denom_social;

	public String segmento_mercado;

	public String tipo_de_capital;

	public Double capital;

	public Date aprovado_em;

	public Integer qtd_on;

	public Integer qtd_pn;

	public Integer qtd_total;

	public String classe_1;

	public Integer qtd_classe_1;

	public String classe_2;

	public Integer qtd_classe_2;

	public String classe_3;

	public Integer qtd_classe_3;

	public String classe_4;

	public Integer qtd_classe_4;

	public String classe_5;

	public Integer qtd_classe_5;

	public String classe_6;

	public Integer qtd_classe_6;

	public Date updated_at;

}
