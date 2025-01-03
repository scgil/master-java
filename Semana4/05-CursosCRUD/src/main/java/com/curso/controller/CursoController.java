package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursoService;

/**
 * Controlador REST para gestionar los {@link Curso}.
 * Emplea el servicio {@link CursoService}
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */

@RestController
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	// http://localhost:8080/cursos/{codCurso}
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable int codCurso) {
		return cursoService.buscarCurso(codCurso);
	}
	
	// http://localhost:8080/cursos/precio?precioMin=100&precioMax=500
	@GetMapping(value="cursos/precio", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPorPrecio(@RequestParam double precioMin, @RequestParam double precioMax) {
		return cursoService.cursosPorPrecio(precioMin, precioMax);
		
	}
	
	// http://localhost:8080/cursos
	
	@PostMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso) {
		return cursoService.altaCurso(curso);
	}
	
	// http://localhost:8080/cursos/{codCurso}/duracion/{duracion}

	@PatchMapping(value="cursos/{codCurso}/duracion/{duracion}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCurso(@PathVariable int codCurso, @PathVariable double duracion) {
		cursoService.actualizarCurso(codCurso, duracion);
	}
	
	// http://localhost:8080/cursos/{codCurso}
	
	@DeleteMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable int codCurso){
		return cursoService.eliminarCurso(codCurso);
	}

}
