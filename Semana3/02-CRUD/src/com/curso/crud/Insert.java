package com.curso.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.curso.conexion.ConexionBD;

public class Insert {

	public static void main(String[] args) {
		Connection conex = null;
		String query = "INSERT INTO personas (nombre, apellido, edad) VALUES('Eva', 'Solana', '48')";
		
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		if(conex!=null) {
			System.out.println("Conectado correctamente");
			try (Statement sentencia = conex.createStatement();){
				sentencia.executeUpdate(query);
				System.out.println("Registro insertado");
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}

}
