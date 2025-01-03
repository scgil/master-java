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

import com.curso.model.Vuelo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VueloControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private int plazasBadRequest;
    private int plazasOkay;
    private int idOkay;
    private int idNotFound;
    private final String URL = "http://localhost:9000/api/vuelos";
    @BeforeEach
    void setUp() {
    	idOkay = 1;
    	idNotFound = 999;
    	plazasOkay = 5;
        plazasBadRequest = -1;
        
    }

    @Test
    void testFindAllVuelos() {
        ResponseEntity<List<Vuelo>> response = restTemplate.exchange(URL, HttpMethod.GET, null,new ParameterizedTypeReference<List<Vuelo>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void testFindVuelosDisponibles() {
    	ResponseEntity<List<Vuelo>> response = restTemplate.exchange(URL +"/"+ plazasOkay, HttpMethod.GET, null, new ParameterizedTypeReference<List<Vuelo>>() {});

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void testFindVuelosDisponiblesBadRequest() {
        
    	ResponseEntity<List<Vuelo>> response = restTemplate.exchange(URL +"/"+ plazasBadRequest, HttpMethod.GET, null, new ParameterizedTypeReference<List<Vuelo>>() {});

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testActualizarPlazas() {
        
        HttpEntity<Void> request = new HttpEntity<>(null);
        ResponseEntity<Void> response = restTemplate.exchange(URL +"/"+ idOkay + "/" + plazasOkay, HttpMethod.PATCH, request, Void.class);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testActualizarPlazasBadRequest() {
        
        HttpEntity<Void> request = new HttpEntity<>(null);
        ResponseEntity<Void> response = restTemplate.exchange(URL +"/"+ idOkay + "/" + plazasBadRequest, HttpMethod.PATCH, request, Void.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testActualizarPlazasNotFound() {
        
        HttpEntity<Void> request = new HttpEntity<>(null);
        ResponseEntity<Void> response = restTemplate.exchange(URL +"/" + idNotFound + "/" + plazasOkay, HttpMethod.PATCH, request, Void.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}