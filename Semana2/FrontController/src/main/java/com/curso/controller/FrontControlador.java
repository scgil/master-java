package com.curso.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControlador
 */
public class FrontControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");
		String urlVista = "/";
		switch (option) {
		case "alta":
			urlVista = "alta.html";
			break;
		case "baja":
			urlVista = "baja.jsp";
			break;
		case "modificar":
			urlVista = "modificar.jsp";
			break;
		case "listado":
			urlVista = "Listar";
			break;
		case "buscar":
			urlVista = "ServletBuscar";
			break;
		}
		RequestDispatcher despachador = request.getRequestDispatcher(urlVista);
		despachador.forward(request, response);
		
		//request.getRequestDispatcher(urlVista).forward(request, response);
	}

}
