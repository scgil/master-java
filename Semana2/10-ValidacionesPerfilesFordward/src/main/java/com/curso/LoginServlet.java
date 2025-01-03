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


        if ("admin".equals(usuario) && "admin".equals(password)) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("BienvenidaServlet");

            dispatcher.forward(request, response);

        } else {

            
            response.setContentType("text/html");

    		PrintWriter out = response.getWriter();

    		out.println("<!DOCTYPE html>");
    		out.println("<html>");
    		out.println("<head>");
    		out.println("<meta charset=\"UTF-8\">");
    		out.println("<title>Eco datos</title>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("<p>");
    		out.println("Usuario o contraseña incorrectos.");
    		out.println("</p>");
    		out.println("<h1>Login</h1>");
    		out.println("<form action=\"LoginServlet\" method=\"post\">");
    		out.println("<label for=\"usuario\">Usuario</label>");
    		out.println("<input type=\"text\" name=\"usuario\"><br>");
    		out.println("<label for=\"password\">Password</label>");
    		out.println("<input type=\"text\" name=\"password\"><br>");
    		out.println("<button  type=\"submit\" id=\"enviar\">Buscar</button>");
    		out.println("<p>(admin, admin)</p>");
    		out.println("</form>");
    		out.println("</body>");
    		out.println("</html>");
    		out.close();

           
            

        }

    }

}
