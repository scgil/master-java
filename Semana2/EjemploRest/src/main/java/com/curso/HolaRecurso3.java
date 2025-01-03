package com.curso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("saludos3")
public class HolaRecurso3 {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String crearJson() {
		return "{\"nombre\":\"Pepito\",\"edad\": 32,\"departamento\":\"ventas\"}";
	}


}
