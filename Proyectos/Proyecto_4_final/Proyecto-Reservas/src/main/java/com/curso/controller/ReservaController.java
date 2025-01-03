package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.curso.model.Reserva;
import com.curso.model.ReservaRequestDTO;
import com.curso.model.ReservaResponseDTO;
import com.curso.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
/** 
 * Controlador REST para el recurso de la entidad {@link Reserva}. 
 * Este controlador proporciona endpoints para gestionar las reservas. Emplea el servicio {@link ReservaService}
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Tag(name = "Reservas", description = "API de Reservas")
@RestController
@RequestMapping("api/reservas")
public class ReservaController {
	@Autowired
	ReservaService reservaService;
	@Operation(summary = "Crea una nueva reserva", description = "Crea una nueva reserva en el sistema con los detalles proporcionados.", responses = {
			@ApiResponse(responseCode = "201", description = "Reserva creada exitosamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida") })
	
	@PostMapping()
	public ResponseEntity<String> altaReserva(@RequestBody ReservaRequestDTO reservaRequestDTO){
		
		try {
			reservaService.altaReserva(reservaRequestDTO);
			return new ResponseEntity<String>("Reserva creada", HttpStatus.CREATED);
			
		}catch(RuntimeException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	@Operation(summary = "Encuentra reservas por nombre de hotel", description = "Devuelve una lista de reservas para el hotel especificado por su nombre.", responses = {
			@ApiResponse(responseCode = "200", description = "Lista de reservas obtenida exitosamente", content = @Content(schema = @Schema(implementation = ReservaResponseDTO.class))),
			@ApiResponse(responseCode = "404", description = "Hotel no encontrado") })
	
	@GetMapping("/{nombreHotel}")
	public ResponseEntity<List<ReservaResponseDTO>> findReservasByNombreHotel(@PathVariable String nombreHotel){
		
		try {
			List<ReservaResponseDTO> reservasHotel = reservaService.findReservasByNombreHotel(nombreHotel);
			
			return new ResponseEntity<>(reservasHotel, HttpStatus.OK);
			
		}catch(HttpClientErrorException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	

}
