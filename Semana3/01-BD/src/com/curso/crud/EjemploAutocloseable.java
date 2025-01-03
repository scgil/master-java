package com.curso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploAutocloseable {
	public static void main(String[] args) {
		final String URL= "jdbc:mysql://localhost:3306/bdcurso";
		final String USER="root";
		final String PWD = "root";
		final String QUERY = "INSERT INTO personas (nombre, apellido, edad) VALUES('Pepito', 'Gil', '22')";
		
		try(Connection conexion = DriverManager.getConnection(URL, USER, PWD);
				Statement sentencia = conexion.createStatement();	
			){
			
			sentencia.executeUpdate(QUERY);
			System.out.println("Eco de sentencia.executeUpdate(query)= "+sentencia.executeUpdate(QUERY));
			System.out.println("Registro insertado");
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
}
