package com.curso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1 {
	public static void main(String[] args) {
		final String URL= "jdbc:mysql://localhost:3306/bdcurso";
		final String USER="root";
		final String PWD = "root";
		final String QUERY = "INSERT INTO personas (nombre, apellido, edad) VALUES('Pepito', 'Gil', '22')";
		
		//Establece conexión
		//Crear Statement(sentencia SQL)
		//Ejecutar
		
		try {
			Connection conexion = DriverManager.getConnection(URL, USER, PWD);
			//System.out.println("Conexión establecida con éxito");
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate(QUERY);
			System.out.println("Eco de sentencia.executeUpdate(query)= "+sentencia.executeUpdate(QUERY));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
