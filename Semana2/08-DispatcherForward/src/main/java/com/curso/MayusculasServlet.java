package com.curso;



import java.io.IOException;



import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

/**

 * Servlet implementation class MayusculasServlet

 */

public class MayusculasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

      
	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Convierte la frase a mayúsculas pero no genera contenido, eso lo hará "FinalServlet"		

		String frase = request.getParameter("frase");

		request.setAttribute("frase", frase.toUpperCase());

		RequestDispatcher despachador = request.getRequestDispatcher("FinalServlet");

		despachador.forward(request, response);

	}

}

