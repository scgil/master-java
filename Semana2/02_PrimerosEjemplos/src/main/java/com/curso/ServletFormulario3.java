package com.curso;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFormulario3
 */
public class ServletFormulario3 extends HttpServlet {
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
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
              
        String[] opciones = request.getParameterValues("opciones");
        
        if(opciones != null) {
        	out.println("Opciones escogidas");
            for(String opcion: opciones) {
            	
            	out.println("<br>");
            	out.println(opcion);
            }
        }else {
        	out.println("No has seleccionado alguna opción.");
        }
        
        
        out.println("<p> </p>");
        out.println("</body>");
        
        out.close();
	}

}
