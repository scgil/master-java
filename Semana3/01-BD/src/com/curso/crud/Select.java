package com.curso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		final String URL= "jdbc:mysql://localhost:3306/bdcurso";
		final String USER="root";
		final String PWD = "root";
		final String QUERY = "SELECT * FROM personas";
		
		try(Connection conexion = DriverManager.getConnection(URL, USER, PWD);
				Statement sentencia = conexion.createStatement();
				ResultSet rs = sentencia.executeQuery(QUERY);
			){
			
			while(rs.next()) {
				System.out.println(rs.getString("nombre")+" "+rs.getString("apellido")+" "+ rs.getInt("edad"));
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

}
