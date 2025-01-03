package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Ejemplar;
@Service
public class EjemplarServiceImpl implements EjemplarService {
	@Autowired
	RestTemplate template;
	private static final String URL = "http://localhost:8080/libros";
	@Override
	public List<Ejemplar> nuevoEjemplar(Ejemplar ejemplar) {
		template.postForLocation(URL, ejemplar);
		return Arrays.asList(template.getForObject(URL, Ejemplar[].class));
	}

}
