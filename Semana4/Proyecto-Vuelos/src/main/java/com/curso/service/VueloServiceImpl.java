package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;
/**
 * Implementación del servicio para la entidad {@link Vuelo}
 * Esta clase implementa la interfaz {@link VueloService} y utiliza el repositorio {@link VueloRepository} para realizar las operaciones.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Service
public class VueloServiceImpl implements VueloService {
	@Autowired
	private VueloRepository vueloRepository;
	@Override
	public List<Vuelo> findAllVuelos() {
		
		return vueloRepository.findAll();
	}

	@Override
	public List<Vuelo> findVuelosDisponibles(int plazas) {
		if(plazas > 0) {			
			return vueloRepository.findByPlazasDisponiblesGreaterThanEqual(plazas);
		}else {
			throw new IllegalArgumentException("Numero de plazas incorrecto");
		}
		
	}

	@Override
	public void actualizarPlazas(int idVuelo, int plazasReserva) {
		Optional<Vuelo> vueloExistente = vueloRepository.findById(idVuelo);
		
		if(vueloExistente.isPresent()) {
			Vuelo vueloActualizar = vueloExistente.get();
			int plazasDisponibles = vueloActualizar.getPlazasDisponibles();
			if(plazasDisponibles >= plazasReserva && plazasReserva > 0) {
				vueloActualizar.setPlazasDisponibles(plazasDisponibles-plazasReserva);
				vueloRepository.save(vueloActualizar);
			}else {
				throw new IllegalArgumentException("Numero de plazas a reservar incorrecto");
			}
			
		}else {
			throw new RuntimeException("Vuelo no encontrado");
		}
		

	}

}
