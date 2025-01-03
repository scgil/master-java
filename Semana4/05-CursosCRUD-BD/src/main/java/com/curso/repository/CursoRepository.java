package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Curso;

/**
 * Repositorio para gestionar los cursos.
 * Proporciona métodos para realizar operaciones CRUD y consultas personalizadas en la entidad {@link Curso}.
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	@Query("SELECT c FROM Curso c WHERE c.precio >= :precioMin AND c.precio <= :precioMax")
	List<Curso> cursosPorPrecio(double precioMin, double precioMax);

}
