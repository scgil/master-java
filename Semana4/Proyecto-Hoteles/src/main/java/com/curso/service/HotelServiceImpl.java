package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;
/**
 * Implementación del servicio para la entidad {@link Hotel}
 * Esta clase implementa la interfaz {@link HotelService} y utiliza el repositorio {@link HotelRepository} para realizar las operaciones.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	@Override
	public List<Hotel> findAllHoteles() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findHotelByNombre(String nombre) {
		
		Optional<Hotel> hotel = hotelRepository.findByNombre(nombre);
		if(hotel.isPresent()) {
			return hotel.get();
		}else {
			throw new RuntimeException("Hotel no encontrado");
		}
		
	}

	@Override
	public List<Hotel> findHotelesDisponibles() {
		boolean disponible = true;
		return hotelRepository.findByDisponible(disponible);
	}

}
