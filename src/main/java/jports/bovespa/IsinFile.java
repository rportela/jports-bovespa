package jports.bovespa;

import java.util.List;

public class IsinFile {

	private List<IsinFileEmissor> emissores;
	private List<IsinFileTitulo> titulos;

	/**
	 * @return the emissores
	 */
	public final List<IsinFileEmissor> getEmissores() {
		return emissores;
	}

	/**
	 * @param emissores
	 *            the emissores to set
	 */
	public final IsinFile setEmissores(List<IsinFileEmissor> emissores) {
		this.emissores = emissores;
		return this;
	}

	/**
	 * @return the titulos
	 */
	public final List<IsinFileTitulo> getTitulos() {
		return titulos;
	}

	/**
	 * @param titulos
	 *            the titulos to set
	 */
	public final IsinFile setTitulos(List<IsinFileTitulo> titulos) {
		this.titulos = titulos;
		return this;
	}

}
