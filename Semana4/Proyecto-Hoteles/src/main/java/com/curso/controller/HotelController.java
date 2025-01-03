package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/** 
 * Controlador REST para el recurso de la entidad {@link Hotel}. 
 * Este controlador proporciona endpoints para acceder a los datos de los hoteles. Emplea el servicio {@link HotelService}
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Tag(name = "Hoteles", description = "API de Hoteles")

@RestController
@RequestMapping("api/hoteles")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@Operation(summary = "Obtiene todos los hoteles", description = "Devuelve una lista de todos los hoteles en la base de datos", responses = { 
			@ApiResponse(responseCode = "200", description = "Lista de hoteles obtenida exitosamente", content = @Content(schema = @Schema(implementation = Hotel.class))),
			 })
	@GetMapping
	public ResponseEntity<List<Hotel>> findAllHoteles(){
		List<Hotel> hoteles = hotelService.findAllHoteles();
		return new ResponseEntity<>(hoteles, HttpStatus.OK);
	}
	@Operation(summary = "Obtiene un hotel por su nombre", description = "Devuelve un hotel basado en el nombre proporcionado", responses = {
			@ApiResponse(responseCode = "200", description = "Hotel encontrado exitosamente", content = @Content(schema = @Schema(implementation = Hotel.class))),
			@ApiResponse(responseCode = "404", description = "Hotel no encontrado") })
	@GetMapping("/{nombre}")
	public ResponseEntity<Hotel> findHotelByNombre(@PathVariable String nombre){
		try {
			Hotel hotel = hotelService.findHotelByNombre(nombre);
			return new ResponseEntity<>(hotel, HttpStatus.OK);
		}catch (RuntimeException e){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			
		}
	}
	@Operation(summary = "Obtiene hoteles disponibles", description = "Devuelve una lista de hoteles que están actualmente disponibles", responses = {
			@ApiResponse(responseCode = "200", description = "Lista de hoteles disponibles obtenida exitosamente", content = @Content(schema = @Schema(implementation = Hotel.class))),
			 })
	@GetMapping("/disponibles")
	public ResponseEntity<List<Hotel>> findHoltelesDisponibles(){
		List<Hotel> hoteles = hotelService.findHotelesDisponibles();
		return new ResponseEntity<>(hoteles, HttpStatus.OK);
	}
	
	

}
