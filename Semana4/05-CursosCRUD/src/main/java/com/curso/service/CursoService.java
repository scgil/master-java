package com.curso.service;

import java.util.List;

import com.curso.model.Curso;
/**
 * Interfaz para el servicio de cursos {@CursoServiceImpl}.
 * Ofrece operaciones para gestionar la entidad {@link Curso}
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */

public interface CursoService {
	
	List<Curso> altaCurso(Curso curso);
	List<Curso> cursos();
	List<Curso> eliminarCurso(int codCurso);
	void actualizarCurso(int codCurso, double duracion);
	Curso buscarCurso(int codCurso);
	List<Curso> cursosPorPrecio(double precioMin, double precioMax);
	
	
	

}
