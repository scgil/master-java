package com.curso.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * Clase que representa un vuelo.
 * La clase Vuelo es una entidad JPA que se mapea a la tabla "vuelos" en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Entity
@Table(name="vuelos")
public class Vuelo {
	@Id
	@Column(name="id_vuelos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	String compania;
	@Column(name="fecha_vuelo")
	LocalDate fechaVuelo;
	double precio;
	@Column(name="plazas_disponibles")
	int plazasDisponibles;
	public Vuelo() {
		super();
	}
	public Vuelo(String compania, LocalDate fechaVuelo, double precio, int plazasDisponibles) {
		super();
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}
	public int getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public LocalDate getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(LocalDate fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}
	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}
	
	

}
