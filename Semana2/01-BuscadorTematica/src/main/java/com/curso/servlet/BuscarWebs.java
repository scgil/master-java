package com.curso.servlet;

import java.io.IOException;

import com.curso.service.PaginaWebService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuscarWebs
 */
public class BuscarWebs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaginaWebService servicio;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tematica = request.getParameter("nombreTematica");
		
		servicio = new PaginaWebService();
		
	
		
		request.setAttribute("tematica", servicio.paginasWebPorTematica(tematica));
		RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
		dispatcher.forward(request, response);
			
		
		}
	}


