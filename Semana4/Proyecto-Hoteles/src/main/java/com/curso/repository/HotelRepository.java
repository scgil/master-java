package com.curso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;

/**
 * Repositorio para la entidad {@link Hotel}
 * Esta interfaz extiende JpaRepository y proporciona métodos para realizar operaciones CRUD en la entidad Hotel. También incluye métodos personalizados.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public interface HotelRepository extends JpaRepository<Hotel,Integer>{
	List<Hotel> findByDisponible(boolean disponible);
	Optional<Hotel> findByNombre(String nombre);
	

}
