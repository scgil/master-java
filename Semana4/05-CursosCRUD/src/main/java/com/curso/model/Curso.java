package com.curso.model;

/**
 * Entidad que representa un curso.
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */
public class Curso {
	private int codCurso;
	String nombre;
	double duracion;
	double precio;
	public Curso() {
		super();
	}
	public Curso(int codCurso, String nombre, double duracion, double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}
