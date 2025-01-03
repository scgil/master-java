package com.curso.modelo;

/**
 * Clase que representa una página web
 * @author Sergio Castro
 * @version 1.0 2024/12/16
 */
public class PaginaWeb {

	private String url;
	private String tematica;
	private String descripcion;
	public PaginaWeb(String url, String tematica, String descripcion) {
		this.url = url;
		this.tematica = tematica;
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
