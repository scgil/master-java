package com.curso;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet para manejar formulario Login
 * @author Sergio Castro
 * @version 1.0 2024/12/16
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");

        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Eco datos</title>");
		out.println("</head>");
		out.println("<body>");

        if ("admin".equals(usuario) && "admin".equals(password)) {
        	out.println("<p>");
    		out.println("Bienvenido");
    		out.println("</p>");
            
        } else {
        	response.getWriter().println("Los datos son incorrectos.");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");

            dispatcher.include(request, response);

        }
        
		out.println("</body>");
		out.println("</html>");
		out.close();
        

    }

}
