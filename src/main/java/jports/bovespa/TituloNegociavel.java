package jports.bovespa;

import java.util.ArrayList;
import java.util.List;

public class TituloNegociavel {

	private final List<TituloNegociavelEmpresa> empresas = new ArrayList<>(2500);
	private final List<TituloNegociavelItem> titulos = new ArrayList<>(2500);

	public TituloNegociavel addEmpresa(TituloNegociavelEmpresa empresa) {
		this.empresas.add(empresa);
		return this;
	}

	public TituloNegociavel addTitulo(TituloNegociavelItem titulo) {
		this.titulos.add(titulo);
		return this;
	}

	public List<TituloNegociavelEmpresa> getEmpresas() {
		return this.empresas;
	}

	public List<TituloNegociavelItem> getTitulos() {
		return this.titulos;
	}
}
