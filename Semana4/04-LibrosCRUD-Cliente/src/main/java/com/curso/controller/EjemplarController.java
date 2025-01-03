package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Ejemplar;
import com.curso.service.EjemplarService;

@RestController
public class EjemplarController {
	@Autowired
	EjemplarService service;
	
	@PostMapping(value="ejemplar/{isbn}/{titulo}/{tematica}")
	public List<Ejemplar> altaEjemplar(@PathVariable int isbn, 
			@PathVariable String titulo,@PathVariable String tematica){
		Ejemplar ejemplar = new Ejemplar(isbn, titulo, tematica);
		return service.nuevoEjemplar(ejemplar);
	}

}
