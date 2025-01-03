package com.curso.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.curso.conexion.ConexionBD;

/**
 * La clase Select representa las operaciones SELECT de base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class Select {
	
	

	public static void main(String[] args) {
		Connection conex = null;
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		String query1 = "SELECT * FROM peliculas";
		String query2 = "SELECT * FROM peliculas WHERE nombre_director=?";
		String query3 = "SELECT * FROM peliculas WHERE nombre_director LIKE ?";
		String query4 = "SELECT * FROM peliculas WHERE nombre_director IN (?, ?)";
		String query5 = "SELECT nombre_director FROM peliculas";
		String query6 = "SELECT * FROM peliculas WHERE precio_alquiler > ? AND < ?";
		
		
		if(conex!=null) {
			mostrarQuery1(conex, query1);
			mostrarQuery2(conex, query2);
			mostrarQuery3(conex, query3);
			mostrarQuery4(conex, query4);
			mostrarQuery5(conex, query5);
			mostrarQuery6(conex, query6);
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}
	
	public static void mostrarQuery1(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String nombreDirector = rs.getString("nombre_director");
				double precioAlquiler = rs.getDouble("precio_alquiler");
				System.out.println(codigo+"|"+titulo+"|"+ nombreDirector+"|"+precioAlquiler);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarQuery2(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			sentencia.setString(1, "Cosme");
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String nombreDirector = rs.getString("nombre_director");
				double precioAlquiler = rs.getDouble("precio_alquiler");
				System.out.println(codigo+"|"+titulo+"|"+ nombreDirector+"|"+precioAlquiler);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarQuery3(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			sentencia.setString(1, "M%");
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String nombreDirector = rs.getString("nombre_director");
				double precioAlquiler = rs.getDouble("precio_alquiler");
				System.out.println(codigo+"|"+titulo+"|"+ nombreDirector+"|"+precioAlquiler);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void mostrarQuery4(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			sentencia.setString(1, "Ana");
			sentencia.setString(2, "Eva");
			
			ResultSet rs = sentencia.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String nombreDirector = rs.getString("nombre_director");
				double precioAlquiler = rs.getDouble("precio_alquiler");
				System.out.println(codigo+"|"+titulo+"|"+ nombreDirector+"|"+precioAlquiler);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void mostrarQuery5(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){

			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				
				String nombreDirector = rs.getString("nombre_director");
			
				System.out.println("Nombre director: "+ nombreDirector);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void mostrarQuery6(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			sentencia.setDouble(1, 20.0);
			sentencia.setDouble(2, 55.0);
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String nombreDirector = rs.getString("nombre_director");
				double precioAlquiler = rs.getDouble("precio_alquiler");
				System.out.println(codigo+"|"+titulo+"|"+ nombreDirector+"|"+precioAlquiler);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
