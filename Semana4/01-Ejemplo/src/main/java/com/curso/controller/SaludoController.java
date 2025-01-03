package com.curso.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Info;

@RestController
public class SaludoController {
	// http://localhost:8080/saludo GET
	@GetMapping(value="saludo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludar() {
		return "Hola desde Spring";
	}
	// http://localhost:8080/saludo/Pepito/Grillo GET
	@GetMapping(value= "saludo/{x}/{y}", produces= MediaType.TEXT_PLAIN_VALUE)
	public String saludar(@PathVariable("x") String nombre,
						  @PathVariable("y") String apellido) {
		return "Hola desde Spring "+ nombre+" "+apellido;
	}
	// http://localhost:8080/saludo2?x=eva&y=gil
	@GetMapping(value="saludo2", produces=MediaType.TEXT_PLAIN_VALUE)
	public String saludar2(@RequestParam("x") String nombre,@RequestParam("y") String apellido) {
		return "Hola desde Spring. Tu nombre es "+nombre+" y tu apellido "+apellido;
	}
	// http://localhost:8080/infocliente
	@GetMapping(value="infocliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public Info informacion() {
		return new Info("ana", 36, "ana@lqs.com");
	}
}
