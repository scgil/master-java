package com.curso;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrearCookie
 */
public class CrearCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c1 = new Cookie("nombre", "Pepito");
		c1.setMaxAge(30);
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("edad", "18");
		c1.setMaxAge(30);
		response.addCookie(c2);

	}

	
}
