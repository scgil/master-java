package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.curso.modelo.Persona;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet para manejar formulario Curso
 * @author Sergio Castro
 * @version 1.0 2024/12/16
 */
public class ServletCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession sesion = request.getSession();

		Persona persona = (Persona) sesion.getAttribute("persona");
		
		String cursoInput = request.getParameter("nombreCurso");
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
       
        if(persona==null) {
			out.println("<p>No se ha detectado sesión.</p>");
		}else if (cursoInput==null || cursoInput.isEmpty()){
			out.println("<p>No se ha introducido un curso.</p>");
			}else {
				persona.insertarCurso(cursoInput);
				out.println("<h1>"+persona.getNombre()+", estás matriculado en los siguientes cursos: </h1>");
		        
		        List<String> cursos = persona.getCursos();
		        for(String curso: cursos) {
		        	out.println("<p>"+curso+"</p>");
		        	
		        }
		        out.println("<a href='formularioCurso.html'>Matricularse en otro curso.</a>");
		        out.println("</body>");
		        out.println("</html>");
		        
		        out.close();
		}
        
	}
}
