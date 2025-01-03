package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Vuelo;
/**
 * Repositorio para la entidad {@link Vuelo}
 * Esta interfaz extiende JpaRepository y proporciona métodos para realizar operaciones CRUD en la entidad Vuelo.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer>{
	/*
	@Query("SELECT v FROM Vuelo v WHERE v.plazasDisponibles = :plazas")
	public List<Vuelo> findVuelosDisponibles(int plazas);
	*/
	public List<Vuelo >findByPlazasDisponiblesGreaterThanEqual(int plazas);

}
