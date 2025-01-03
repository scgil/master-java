package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.HotelDTO;
import com.curso.model.Reserva;
import com.curso.model.ReservaRequestDTO;
import com.curso.model.ReservaResponseDTO;
import com.curso.model.VueloDTO;
import com.curso.repository.ReservaRepository;
/**
 * Implementación del servicio para gestionar reservas
 * Esta clase implementa la interfaz {@link ReservaService} y utiliza el repositorio {@link ReservaRepository} para realizar las operaciones.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Service
public class ReservaServiceImpl implements ReservaService {
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private RestTemplate template;
	private final String URL_VUELOS_DISPONIBLES = "http://localhost:9000/api/vuelos/{plazas}";
	private final String URL_VUELO_ACTUALIZAR = "http://localhost:9000/api/vuelos/{id}/{plazasReserva}";
	private final String URL_HOTEL_NOMBRE = "http://localhost:8080/api/hoteles/{nombre}";
	private final String URL_HOTELES_DISPONIBLES = "http://localhost:8080/api/hoteles/disponibles";
	
	
	@Override
	public void altaReserva(ReservaRequestDTO reservaRequestDTO) {
		
		if(reservaRequestDTO.getTotalPersonas()>0) {
			HotelDTO[] hotelesDisponibles = template.getForObject(URL_HOTELES_DISPONIBLES,HotelDTO[].class);
			
			if(hotelesDisponibles.length > 0) {
				HotelDTO hotelDTO = HotelDTO.encontrarHotelPorId(hotelesDisponibles, reservaRequestDTO.getIdHotel());
				VueloDTO[] vuelosDisponibles = template.getForObject(URL_VUELOS_DISPONIBLES,VueloDTO[].class,reservaRequestDTO.getTotalPersonas());
				
				if(vuelosDisponibles.length > 0 && hotelDTO != null) {
					VueloDTO vueloDTO = VueloDTO.encontrarVueloPorId(vuelosDisponibles, reservaRequestDTO.getIdVuelo());
					if(vueloDTO != null) {
						String nombreCliente = reservaRequestDTO.getNombreCliente();
						String dni = reservaRequestDTO.getDni();
						int idHotel = reservaRequestDTO.getIdHotel();
						int idVuelo = reservaRequestDTO.getIdVuelo();
						int plazas = reservaRequestDTO.getTotalPersonas();
						
						HttpHeaders headers = new HttpHeaders(); 
						headers.setContentType(MediaType.APPLICATION_JSON);
						HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
						template.exchange(URL_VUELO_ACTUALIZAR, HttpMethod.PATCH, requestEntity, Void.class, idVuelo, plazas);
						
						Reserva reserva = new Reserva(nombreCliente, dni, idHotel, idVuelo);
						reservaRepository.save(reserva);
						
					}else {
						throw new RuntimeException("Id de vuelo incorrecto");
					}
				}else {
					throw new RuntimeException("Vuelo sin plazas suficientes u Id de hotel incorrecto");
				}
			
			
			}else {
				throw new RuntimeException("No hay hoteles disponibles");
			}
		}else {
			throw new RuntimeException("El número de plazas no puede ser negativo o 0");
		}
		
	}

	@Override
	public List<ReservaResponseDTO> findReservasByNombreHotel(String nombreHotel) {
		
		HotelDTO hotel = template.getForObject(URL_HOTEL_NOMBRE,HotelDTO.class, nombreHotel);
		
		List<ReservaResponseDTO> reservasResponseDTO = new ArrayList<>();
		

			
			List<Reserva> reservas = reservaRepository.findByIdHotel(hotel.getIdHotel());
			
			if(!reservas.isEmpty()) {
				
				for(Reserva r: reservas) {
					reservasResponseDTO.add(new ReservaResponseDTO(r.getNombreCliente(), r.getDni(), r.getIdVuelo()));
				}
						
			}else {
				throw new IllegalArgumentException("No hay reservas para ese hotel");
			}
			
		
		return reservasResponseDTO;
		
	}

}
