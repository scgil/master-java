package com.curso.crud;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.curso.conexion.ConexionBD;

public class Update {

	public static void main(String[] args) {
		Connection conex = null;
		String query = "UPDATE personas SET edad=18 WHERE nombre='Eva'";
		
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		if(conex!=null) {
			System.out.println("Conectado correctamente");
			try (Statement sentencia = conex.createStatement();){
				if(sentencia.executeUpdate(query)>0) {
					System.out.println("Registro actualizado correctamente");
				}else {
					System.out.println("Ningún registro cumple la condición");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}

}
