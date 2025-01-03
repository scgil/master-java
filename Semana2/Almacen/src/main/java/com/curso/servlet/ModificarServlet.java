package com.curso.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.curso.modelo.Producto;

/**
 * Servlet para seleccionar el producto a modificar 
 * @author Sergio Castro
 * @version 1.0 2024/12/17
 */
public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String indexModificar = request.getParameter("indexModificar");
		
		if(indexModificar != null && !indexModificar.isEmpty()) {
			int index = Integer.parseInt(indexModificar) ;
			
			request.setAttribute("indiceModificar", index);
			RequestDispatcher dispatcher = request.getRequestDispatcher("modificarProducto.jsp");
			dispatcher.forward(request, response);	
			
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<meta charset=\"UTF-8\">");
	        out.println("<title></title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<p>No se ha podido modificar el producto.</p>");
			out.println("<a href='index.html'>Volver al índice</a>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}

	

}
