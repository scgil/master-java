package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.curso.modelo.Persona;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet para manejar formulario Persona
 * @author Sergio Castro
 * @version 1.0 2024/12/16
 */
public class ServletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(true);
		
		String nombrePersona = request.getParameter("nombrePersona");
		
		if(nombrePersona!=null || nombrePersona.isEmpty()) {
			Persona persona = new Persona(nombrePersona);
			sesion.setAttribute("persona", persona);
			sesion.setMaxInactiveInterval(100);
			
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	              
	        
	       
	        out.println("<h1>Persona registrada en el sistema</h1>");
	        out.println("<p>Nombre de la persona registrada: "+nombrePersona);
	        
	        out.println("<h1>Se puede matricular en nuestros cursos accediendo a:</h1>");
	        out.println("<a href='formularioCurso.html'>Formulario del curso</a>");
	      
	        out.println("</body>");
	        out.println("</html");
	        
	        out.close();
			
		}
		
	}

}
