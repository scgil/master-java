package com.curso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("saludos") //especificando ruta de acceso
public class HolaRecurso1 {
// http://localhost:8080/EjemploRest/rest/saludos	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String decirHola() {
		return "Hola mundo";
	}


}