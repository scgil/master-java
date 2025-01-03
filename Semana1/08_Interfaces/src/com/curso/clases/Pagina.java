package com.curso.clases;

import com.cursojava.interfaces.Imprimible;

public class Pagina implements Imprimible {
	private int nPaginas;
	private int nLineas;

	/**
	 * @param nPaginas
	 * @param nLineas
	 */
	public Pagina(int nPaginas, int nLineas) {
		this.nPaginas = nPaginas;
		this.nLineas = nLineas;
	}

	@Override
	public void informeLargo() {
		System.out.println("El informe largo de Página tiene: " +nPaginas+ "de páginas");
	}
	@Override
	public void informeCorto() {
		System.out.println("El informe corto de Página tiene: " +nPaginas+ "de páginas "+"y "+nLineas+" líneas");

	}

}
