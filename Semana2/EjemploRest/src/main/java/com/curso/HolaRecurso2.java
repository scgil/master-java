package com.curso;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("saludos2")
public class HolaRecurso2 {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String decirHolaHtml() {
		return "<html><body><h1>Hola mundo</h1></body></html>";
	}

}
