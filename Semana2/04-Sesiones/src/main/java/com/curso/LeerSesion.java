package com.curso;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LeerSesion
 */
public class LeerSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		
		//sesion.getAttribute("curso"); me devuelve un Object (hay que castear)
		String curso = (String) sesion.getAttribute("curso");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title></title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<h1>Resultado de las sesiones</h1>");
        out.println("<p>"+curso+"</p>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
	}

	

}
