package com.curso.crud;

import java.sql.Connection;
import java.sql.Date;
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
		
		String query1 = "SELECT * FROM empleados";
		String query2 = "SELECT codigo, nombre, apellido1, apellido2, fecha_nacimiento, salario FROM empleados WHERE apellido1 = ?";
		String query3 = "SELECT AVG(salario) AS salario_medio FROM empleados";
		
		if(conex!=null) {
			mostrarQuery1(conex, query1);
			mostrarQuery2(conex, query2);
			mostrarQuery3(conex, query3);
			
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}
	
	public static void mostrarQuery1(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				Date fechaNacimiento= rs.getDate("fecha_nacimiento");
				double salario = rs.getDouble("salario");
				System.out.println(codigo+"|"+nombre+"|"+ apellido1+"|"+apellido2+"|"+fechaNacimiento+"|"+salario);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarQuery2(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			sentencia.setString(1, "López");
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nombre = rs.getString("nombre");
				String apellido1 = rs.getString("apellido1");
				String apellido2 = rs.getString("apellido2");
				Date fechaNacimiento= rs.getDate("fecha_nacimiento");
				double salario = rs.getDouble("salario");
				System.out.println(codigo+"|"+nombre+"|"+ apellido1+"|"+apellido2+"|"+fechaNacimiento+"|"+salario);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void mostrarQuery3(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				double salarioMedio = rs.getDouble("salario_medio");
				System.out.println("Salario medio: "+salarioMedio);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
