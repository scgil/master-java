package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;
/**
 * Interfaz del servicio para la entidad {@link Hotel}
 * Esta interfaz define los métodos que deben ser implementados para gestionar los hoteles. 
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public interface HotelService {
	public List<Hotel> findAllHoteles();
	public Hotel findHotelByNombre(String nombre);
	public List<Hotel> findHotelesDisponibles();

	
}
