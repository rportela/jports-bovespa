package jports.bovespa;

import java.util.ArrayList;
import java.util.List;

public class TituloNegociavelFile {

	private final List<TituloNegociavelEmpresa> empresas = new ArrayList<>(2500);
	private final List<TituloNegociavel> titulos = new ArrayList<>(2500);

	public TituloNegociavelFile addEmpresa(TituloNegociavelEmpresa empresa) {
		this.empresas.add(empresa);
		return this;
	}

	public TituloNegociavelFile addTitulo(TituloNegociavel titulo) {
		this.titulos.add(titulo);
		return this;
	}

	public List<TituloNegociavelEmpresa> getEmpresas() {
		return this.empresas;
	}

	public List<TituloNegociavel> getTitulos() {
		return this.titulos;
	}
}
