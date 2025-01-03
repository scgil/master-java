package com.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para manejar bienvenida tras Login
 * @author Sergio Castro
 * @version 1.0 2024/12/16
 */
public class BienvenidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Eco datos</title>");
		out.println("</head>");
		out.println("<body>");
        
        out.println("<h1>Bienvenido, " + request.getParameter("usuario") + "!</h1>");
        out.println("<h2>Has accedido el " + LocalDate.now() + "!</h2>");
        
        out.println("</body>");
		out.println("</html>");
		out.close();
        
        
 

		
		
		
    }


}