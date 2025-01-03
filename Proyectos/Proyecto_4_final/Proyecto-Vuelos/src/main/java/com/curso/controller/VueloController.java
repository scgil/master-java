package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
/** 
 * Controlador REST para el recurso de la entidad {@link Vuelo}. 
 * Este controlador proporciona endpoints para acceder a los datos de los vuelos. Emplea el servicio {@link VueloService}
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Tag(name = "Vuelos", description = "API de Vuelos")
@RestController
@RequestMapping("api/vuelos")
public class VueloController {
	@Autowired
	private VueloService vueloService;
	
	@Operation(summary = "Obtiene todos los vuelos", description = "Devuelve una lista de todos los vuelos en la base de datos", responses = { 
			@ApiResponse(responseCode = "200", description = "Lista de vuelos obtenida exitosamente", content = @Content(schema = @Schema(implementation = Vuelo.class)))
			 })
	
	@GetMapping
	public ResponseEntity<List<Vuelo>> findAllVuelos(){
		List<Vuelo> vuelos = vueloService.findAllVuelos();
		return new ResponseEntity<>(vuelos, HttpStatus.OK);
	}
	@Operation(summary = "Obtiene todos los vuelos con plazas disponibles", description = "Devuelve una lista de todos los vuelos con número de plazas disponible mayor o igual al valor proporcionado.", responses = { 
			@ApiResponse(responseCode = "200", description = "Lista de vuelos obtenida exitosamente", content = @Content(schema = @Schema(implementation = Vuelo.class))),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
			 })
	
	@GetMapping("/{plazas}")
	public ResponseEntity<List<Vuelo>> findVuelosDisponibles(@PathVariable int plazas){
		try {
			List<Vuelo> vuelosDisponibles = vueloService.findVuelosDisponibles(plazas);
			return new ResponseEntity<>(vuelosDisponibles, HttpStatus.OK);
		} catch (IllegalArgumentException e) { 
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		
	}
	
	@Operation(summary = "Actualiza el número de plazas disponibles de un vuelo", description = "Actualiza el número de plazas disponible de un vuelo basado en el identificador proporcionado y las plazas a reservar", responses = { 
			@ApiResponse(responseCode = "204", description = "Plazas actualizadas exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
			@ApiResponse(responseCode = "404", description = "Vuelo no encontrado")
			 })
	
	@PatchMapping("/{id}/{plazasReserva}")
	public ResponseEntity<Void> actualizarPlazas(@PathVariable int id, @PathVariable int plazasReserva){
		
		try {
			vueloService.actualizarPlazas(id, plazasReserva);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
			} catch (IllegalArgumentException e) { 
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				} catch (RuntimeException e) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
					}
	}
	
	

}
