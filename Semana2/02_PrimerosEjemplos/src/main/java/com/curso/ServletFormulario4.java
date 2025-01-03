package com.curso;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFormulario4
 */
public class ServletFormulario4 extends HttpServlet {
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
              
        String opciones = request.getParameter("opciones");
        
        if(opciones != null) {
        	switch(opciones) {
        	case "pilates":   out.println("<p> Curso pilates</p>");
        	case "yoga":   out.println("<p> Curso yoga</p>");
        	case "taichi":   out.println("<p> Curso taichi</p>");
        	}
            
        }else {
        	out.println("No has seleccionado alguna opción.");
        }
        
        
      
        out.println("</body>");
        out.println("</html");
        
        out.close();
	}
}
