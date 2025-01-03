package com.curso.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Pelicula representa la entidad Pelicula
 * @author Sergio Castro 
 * @version 1.0 2023/12/23
 */
@Entity
@Table(name="peliculas")
public class Pelicula implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	private String titulo;
	@Column(name="nombre_director")
	private String nombreDirector;
	@Column(name = "precio_alquiler")
	private double precioAlquiler;
	public Pelicula() {
		super();
	}
	public Pelicula(int codigo) {
		super();
		this.codigo = codigo;
	}
	public Pelicula(int codigo, String titulo, String nombreDirector, double precioAlquiler) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.nombreDirector = nombreDirector;
		this.precioAlquiler = precioAlquiler;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nombreDirector == null) ? 0 : nombreDirector.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioAlquiler);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (codigo != other.codigo)
			return false;
		if (nombreDirector == null) {
			if (other.nombreDirector != null)
				return false;
		} else if (!nombreDirector.equals(other.nombreDirector))
			return false;
		if (Double.doubleToLongBits(precioAlquiler) != Double.doubleToLongBits(other.precioAlquiler))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", nombreDirector=" + nombreDirector
				+ ", precioAlquiler=" + precioAlquiler + "]";
	}
	
	
	
	
	

}
