package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Curso;
import com.curso.repository.CursoRepository;
/**
 * Implementación del servicio para la entidad {@link Curso}.
 * Implementa operaciones para gestionar la entidad {@link Curso}
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */
@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	private CursoRepository repository;
	
	@Override
	public List<Curso> altaCurso(Curso curso) {
		if(curso != null) {
			repository.save(curso);
		}
		
		return repository.findAll();
	}

	@Override
	public List<Curso> cursos() {
		
		return repository.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(int codCurso) {
		repository.deleteById(codCurso);
		return repository.findAll();
	}

	@Override
	public void actualizarCurso(int codCurso, double duracion) {
		Curso curso = repository.findById(codCurso).orElse(null);
		if(curso != null) {
			curso.setDuracion(duracion);
			repository.save(curso);
		}

	}

	@Override
	public Curso buscarCurso(int codCurso) {
		
		return repository.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> cursosPorPrecio(double precioMin, double precioMax) {
		
		return repository.cursosPorPrecio(precioMin, precioMax);
	}

}
