package com.curso;



import java.io.IOException;

import java.io.PrintWriter;



import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



/**

 * Servlet implementation class FinalServlet

 */

public class FinalServlet extends HttpServlet {

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
		out.println("<p>");
		out.println("Valor almacenado en request.getParameter('frase')"+request.getParameter("frase"));
		out.println("</p>");
		out.println("<p>");
		out.println("Valor almacenado en request.getAttribute('frase')"+request.getAttribute("frase"));
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}

