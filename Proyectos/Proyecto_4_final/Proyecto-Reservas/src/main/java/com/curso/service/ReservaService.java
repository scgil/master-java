package com.curso.service;

import java.util.List;

import com.curso.model.ReservaRequestDTO;
import com.curso.model.ReservaResponseDTO;
/**
 * Interfaz del servicio para gestionar reservas.
 * Esta interfaz define los métodos que deben ser implementados para gestionar las reservas. 
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public interface ReservaService {
	public void altaReserva(ReservaRequestDTO reservaRequestDTO);
	public List<ReservaResponseDTO> findReservasByNombreHotel(String nombreHotel);
}
