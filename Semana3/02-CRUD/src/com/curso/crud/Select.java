package com.curso.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.curso.conexion.ConexionBD;

public class Select {

	public static void main(String[] args) {
		Connection conex = null;
		String query = "SELECT * FROM personas";
		
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		if(conex!=null) {
			System.out.println("Conectado correctamente");
			try (Statement sentencia = conex.createStatement();){
				
				ResultSet rs = sentencia.executeQuery(query);
				while(rs.next()) {
					System.out.println(rs.getString("nombre")+" "+rs.getString("apellido")+" "+ rs.getInt("edad"));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}

}
