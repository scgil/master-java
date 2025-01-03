package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Reserva;
/**
 * Repositorio para la entidad {@link Reserva}
 * Esta interfaz extiende JpaRepository y proporciona métodos para realizar operaciones CRUD..
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	public List<Reserva> findByIdHotel(int idHotel);

}
