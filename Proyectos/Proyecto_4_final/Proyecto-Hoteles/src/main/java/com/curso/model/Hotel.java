package com.curso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Clase que representa un hotel.
 * La clase Hotel es una entidad JPA que se mapea a la tabla "hoteles" en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Entity
@Table(name="hoteles")
public class Hotel {
	
	public enum Categoria { UNA_ESTRELLA, DOS_ESTRELLAS, TRES_ESTRELLAS, CUATRO_ESTRELLAS, CINCO_ESTRELLAS }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hotel")
	private int idHotel;
	private String nombre;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private double precio;
	private boolean disponible;
	
	public Hotel() {
		super();
	}


	public Hotel(String nombre, Categoria categoria, double precio, boolean disponible) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	

}
