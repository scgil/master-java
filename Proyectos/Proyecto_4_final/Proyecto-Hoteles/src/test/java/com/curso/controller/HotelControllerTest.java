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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.curso.model.Hotel;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HotelControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String nombreHotelOkay;
    private String nombreHotelNotFound;
    private final String URL = "http://localhost:8080/api/hoteles";

    @BeforeEach
    void setUp() {
        nombreHotelOkay = "Sol";
        nombreHotelNotFound = "HotelIncorrecto";
    }

    @Test
    void testFindAllHoteles() {
        ResponseEntity<List<Hotel>> response = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void testFindHotelByNombre() {
        ResponseEntity<Hotel> response = restTemplate.exchange(URL + "/" + nombreHotelOkay, HttpMethod.GET, null, Hotel.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testFindHotelByNombreNotFound() {
        ResponseEntity<Hotel> response = restTemplate.exchange(URL + "/" + nombreHotelNotFound, HttpMethod.GET, null, Hotel.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testFindHotelesDisponibles() {
        ResponseEntity<List<Hotel>> response = restTemplate.exchange(URL + "/disponibles", HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }
}