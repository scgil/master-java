package com.curso.model;

/**
 * La clase HotelDTO representa un Hotel siguiendo el patrón DTO.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public class HotelDTO {
	public enum Categoria { UNA_ESTRELLA, DOS_ESTRELLAS, TRES_ESTRELLAS, CUATRO_ESTRELLAS, CINCO_ESTRELLAS }
	
	
	private int idHotel;
	private String nombre;
	private Categoria categoria;
	private double precio;
	private boolean disponible;
	

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
	
	public static HotelDTO encontrarHotelPorId(HotelDTO[] hotelDTO, int idHotel) {
		int i = 0;
		boolean continuar = true;
		HotelDTO hotel = null;
		
		while(i < hotelDTO.length && continuar) {
			if(hotelDTO[i].getIdHotel() == idHotel) {
				hotel = hotelDTO[i];
				continuar = false;
			}
			i++;		
		}
		return hotel;
		
	}

}
