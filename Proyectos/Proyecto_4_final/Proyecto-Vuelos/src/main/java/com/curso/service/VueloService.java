package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;
/**
 * Interfaz del servicio para la entidad {@link Vuelo}
 * Esta interfaz define los métodos que deben ser implementados para gestionar los vuelos. 
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public interface VueloService {
	
	public List<Vuelo> findAllVuelos();
	public List<Vuelo> findVuelosDisponibles(int plazas);
	public void actualizarPlazas(int idVuelo, int plazasReserva);
	

}
