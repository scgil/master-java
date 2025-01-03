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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST para gestionar el recurso {@link Curso}.
 * Emplea el servicio {@link CursoService}
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */

@Tag(name = "Cursos", description = "API de cursos")
@RestController
public class CursoController {
	@Autowired
	private CursoService cursoService;
	
	@Operation(summary = "Obtener todos los cursos", description = "Devuelve una lista de todos los cursos", responses = { 
			@ApiResponse(responseCode = "200", description = "Cursos encontrados", content = @Content(schema = @Schema(implementation = Curso.class))), 
			@ApiResponse(responseCode = "204", description = "No hay cursos para devolver"), @ApiResponse(responseCode = "400", description = "Solicitud inválida") })
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> listadoCursos() {
		return cursoService.cursos();
	}
	@Operation(summary = "Buscar un curso por su código", description = "Devuelve un curso basado en su código", responses = { 
			@ApiResponse(responseCode = "200", description = "Curso encontrado", content = @Content(schema = @Schema(implementation = Curso.class))), 
			@ApiResponse(responseCode = "404", description = "Curso no encontrado") })
	// http://localhost:8080/cursos/{codCurso}
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable int codCurso) {
		return cursoService.buscarCurso(codCurso);
	}
	@Operation(summary = "Obtener cursos dentro de un rango de precios", description = "Devuelve una lista de cursos dentro del rango de precios especificado", responses = {
			@ApiResponse(responseCode = "200", description = "Cursos encontrados", content = @Content(schema = @Schema(implementation = Curso.class))),
			@ApiResponse(responseCode = "404", description = "Cursos no encontrados") })
	// http://localhost:8080/cursos/precio?precioMin=100&precioMax=500
	@GetMapping(value="cursos/precio", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPorPrecio(@RequestParam double precioMin, @RequestParam double precioMax) {
		return cursoService.cursosPorPrecio(precioMin, precioMax);
		
	}
	
	
	@Operation(summary = "Dar de alta un nuevo curso", description = "Crea un nuevo curso y lo añade a la lista", responses = { 
			@ApiResponse(responseCode = "201", description = "Curso creado", content = @Content(schema = @Schema(implementation = Curso.class))), 
			@ApiResponse(responseCode = "400", description = "Solicitud inválida") })
	// http://localhost:8080/cursos
	@PostMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso) {
		return cursoService.altaCurso(curso);
	}
	
	@Operation(summary = "Actualizar la duración de un curso", description = "Actualiza la duración de un curso existente", responses = { 
			@ApiResponse(responseCode = "200", description = "Curso actualizado"), 
			@ApiResponse(responseCode = "404", description = "Curso no encontrado") })
	// http://localhost:8080/cursos/{codCurso}/duracion/{duracion}

	@PatchMapping(value="cursos/{codCurso}/duracion/{duracion}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCurso(@PathVariable int codCurso, @PathVariable double duracion) {
		cursoService.actualizarCurso(codCurso, duracion);
	}
	
	@Operation(summary = "Eliminar un curso por su código", description = "Elimina un curso basado en su código", responses = { 
			@ApiResponse(responseCode = "200", description = "Curso eliminado"), 
			@ApiResponse(responseCode = "404", description = "Curso no encontrado") })
	// http://localhost:8080/cursos/{codCurso}
	
	@DeleteMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable int codCurso){
		return cursoService.eliminarCurso(codCurso);
	}
}
