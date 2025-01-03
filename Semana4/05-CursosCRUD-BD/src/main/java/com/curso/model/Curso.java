package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad JPA que representa un curso.
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */
@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@Column(name="cod_curso")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codCurso;
	String nombre;
	double duracion;
	double precio;
	public Curso() {
		super();
	}
	public Curso(String nombre, double duracion, double precio) {

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
	@Override
	public int hashCode() {
		return Objects.hash(codCurso);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codCurso == other.codCurso;
	}
	
	
	

}
