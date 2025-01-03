package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	/*
	@GetMapping(value="/") //http:localhost:8080/
	public String index() {
		return "index"; //página sin indicar la extensión
	}
	@GetMapping(value="/pag2") //http:localhost:8080/pagina2
	public String mostrarPagina2() {
		return "pagina2";
	}
*/
	//Forma equivalente, pero más antigua
	
	@RequestMapping(value="/", method = RequestMethod.GET) //http:localhost:8080/
	public String index() {
		return "index"; //página sin indicar la extensión
	}
	@RequestMapping(value="/pag2", method = RequestMethod.GET) //http:localhost:8080/pagina2
	public String mostrarPagina2() {
		return "pagina2";
	}
	
}
