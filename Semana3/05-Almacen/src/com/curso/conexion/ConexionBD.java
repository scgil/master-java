package com.curso.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * La clase Conexion BD representa una conexión a base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class ConexionBD {
	private static final String URL= "jdbc:mysql://localhost:3306/bdalmacen";
	private static final String USER="root";
	private static final String PWD = "root";
	
	public Connection conexion() {
		Connection conex = null;
		
		try {
			conex = DriverManager.getConnection(URL, USER, PWD);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conex;
	}

}
