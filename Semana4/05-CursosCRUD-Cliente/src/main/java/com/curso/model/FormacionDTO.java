package com.curso.model;
/**
 * DTO para transferir datos de formación.
 * @author Sergio Castro
 * @version 1.0 2024/12/30
 */
public class FormacionDTO {
	private String curso;
	private int asignaturas;
	private double precio;
	public FormacionDTO() {
		super();
	}
	public FormacionDTO(String curso, int asignaturas, double precio) {
		super();
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(int asignaturas) {
		this.asignaturas = asignaturas;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

}
