package com.curso.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.ReservaRequestDTO;
import com.curso.model.ReservaResponseDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservaControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private ReservaRequestDTO reservaCreated;
    private ReservaRequestDTO reservaBadRequest;
    
    private String nombreHotelOkay;
    private String nombreHotelNotFound;
    private final String URL = "http://localhost:9090/api/reservas";

    @BeforeEach
    void setUp() {
    	
        reservaCreated = new ReservaRequestDTO(2,1,"Pepito","12345678A", 5);
        reservaBadRequest = new ReservaRequestDTO(2,1,"Pepito","12345678A", -5);
              
        nombreHotelOkay = "Sol";
        nombreHotelNotFound = "HotelIncorrecto";
        
    }

    @Test
    @DirtiesContext
    @Transactional
    void testAltaReserva() {
        HttpEntity<ReservaRequestDTO> request = new HttpEntity<>(reservaCreated);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, request, String.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Reserva creada", response.getBody());
    }

    @Test
    @DirtiesContext
    @Transactional
    void testAltaReservaBadRequest() {
        

        HttpEntity<ReservaRequestDTO> request = new HttpEntity<>(reservaBadRequest);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, request, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DirtiesContext
    @Transactional
    void testFindReservasByNombreHotel() {
    	ResponseEntity<List<ReservaResponseDTO>> response = restTemplate.exchange(URL +"/"+ nombreHotelOkay, HttpMethod.GET, null, new ParameterizedTypeReference<List<ReservaResponseDTO>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    @DirtiesContext
    @Transactional
    void testFindReservasByNombreHotelNotFound() {
        ResponseEntity<List<ReservaResponseDTO>> response = restTemplate.exchange(URL +"/"+ nombreHotelNotFound, HttpMethod.GET, null, new ParameterizedTypeReference<List<ReservaResponseDTO>>() {});

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

}
