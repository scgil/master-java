package com.curso.servlet;

import java.io.IOException;

import com.curso.modelo.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CrearSesionProducto
 */
public class CrearSesionProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		Producto producto = new Producto(1, "cuaderno", 7.99);
		sesion.setAttribute("producto", producto);
		sesion.setMaxInactiveInterval(100);
	}

	

}
