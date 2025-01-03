package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Libro;
import com.curso.service.LibroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Libros", description = "La API de libros")
@RestController
public class LibroController {
	@Autowired
	LibroService libroService;
	
	// http://localhost:8080/libros
		@Operation(summary = "Obtener todos los libros", description = "devuelve una lista de libros", responses = { 
				@ApiResponse(responseCode = "200", description = "Libros encontrados",
				content = @Content(schema=@Schema(implementation = Libro.class))),
				@ApiResponse(responseCode = "204", description = "No hay libros para devolver"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida")
				})
		@GetMapping(value="libros", produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Libro> libros(){
			return libroService.libros();
		}
		
		// http://localhost:8080/libros/{isbn}
		@Operation(summary = "Obtener libro por isbn", description = "devuelve un libro por su identificador isbn", responses = { 
				@ApiResponse(responseCode = "200", description = "Libro encontrado",
				content = @Content(schema=@Schema(implementation = Libro.class))),
				@ApiResponse(responseCode = "404", description = "Libro no encontrado"),
				})
		@GetMapping(value="libros/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
		public Libro buscarLibro(@PathVariable int isbn) {
			return libroService.buscarLibro(isbn);
		}
		// http://localhost:8080/libros
		@Operation(summary = "Crear un nuevo libro", description = "Añadir un nuevo libro a la lista", responses = { 
				@ApiResponse(responseCode = "201", description = "Libro creado con éxito"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
				})
		@PostMapping(value="libros", consumes=MediaType.APPLICATION_JSON_VALUE)
		public void altaLibro(@RequestBody Libro libro) {
			libroService.altaLibro(libro);
		}
		
		// http://localhost:8080/libros
		@Operation(summary = "Actualizar un libro.", description = "elimina un libro por su isbn y devuelve la lista de libros", responses = { 
				@ApiResponse(responseCode = "200", description = "Libro actualizado exitosamente"),
		        @ApiResponse(responseCode = "404", description = "Libro no encontrado")
				})	
		@PutMapping(value="libros", consumes=MediaType.APPLICATION_JSON_VALUE)
		public void actualizar(@RequestBody Libro libro) {
			libroService.actualizar(libro);
		}
		
		// http://localhost:8080/libros/{isbn}
		@Operation(summary = "Eliminar un libro", description = "elimina un libro por su isbn y devuelve la lista de libros", responses = { 
				@ApiResponse(responseCode = "200", description = "Libro eliminado exitosamente"),
		        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, el ISBN no es válido")
				})
		@DeleteMapping(value="libros/{isbn}", produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Libro> eliminarLibro(@PathVariable int isbn){
			return libroService.eliminarLibro(isbn);
		}
	
		// http://localhost:8080/libros/{titulo}
		@Operation(summary = "Obtener libro por su título", description = "devuelve un libro por su título", responses = { 
				@ApiResponse(responseCode = "200", description = "Libro encontrado",
				content = @Content(schema=@Schema(implementation = Libro.class))),
				@ApiResponse(responseCode = "404", description = "Libro no encontrado"),
				})
		@GetMapping(value="libros/{titulo}", produces=MediaType.APPLICATION_JSON_VALUE)
		public Libro buscarLibroTitulo(@PathVariable String titulo) {
			return libroService.buscarLibroTitulo(titulo);
		}
		
		// http://localhost:8080/libros/{tematica}
		@Operation(summary = "Obtener libro por su temática", description = "devuelve un libro por su temática", responses = { 
				@ApiResponse(responseCode = "200", description = "Libro encontrado",
				content = @Content(schema=@Schema(implementation = Libro.class))),
				@ApiResponse(responseCode = "404", description = "Libro no encontrado"),
				})
		@GetMapping(value="libros/{tematica}", produces=MediaType.APPLICATION_JSON_VALUE)
		public Libro findByTematica(@PathVariable String tematica) {
			return libroService.findByTematica(tematica);
		}
		

		
}
