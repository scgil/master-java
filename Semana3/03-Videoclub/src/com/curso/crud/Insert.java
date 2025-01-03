package com.curso.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.curso.conexion.ConexionBD;

/**
 * La clase Insert representa las operaciones INSERT de base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */

public class Insert {

	public static void main(String[] args) {
		Connection conex = null;
		//Tabla peliculas: codigo(int), titulo(String), nombre_director(String), precio_alquiler(double)
		String query = "INSERT INTO peliculas (codigo, titulo, nombre_director, precio_alquiler) VALUES(?, ?, ?, ?)";
		int codigo = 2;
		String titulo = "Lo que el viento se llevó";
		String nombreDirector = "Pepito";
		double precioAlquiler = 3.0;
		
		
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		if(conex!=null) {
			System.out.println("Conectado correctamente");
			try (PreparedStatement sentencia = conex.prepareStatement(query);){
				sentencia.setInt(1, codigo);
				sentencia.setString(2, titulo);
				sentencia.setString(3, nombreDirector);
				sentencia.setDouble(4, precioAlquiler);
				sentencia.executeUpdate();
				System.out.println("Registro insertado");
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}

}
