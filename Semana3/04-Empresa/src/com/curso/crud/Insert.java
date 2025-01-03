package com.curso.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.curso.conexion.ConexionBD;

/**
 * La clase Insert representa las operaciones INSERT de base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */

public class Insert {

	public static void main(String[] args) {
		Connection conex = null;
		//Tabla empleados: codigo(int), nombre(String), apellido1(String), apellido2(String), fecha_nacimiento(Date), salario(double)
		String query = "INSERT INTO empleados (codigo, nombre, apellido1, apellido2, fecha_nacimiento, salario) VALUES(?, ?, ?, ?, ?, ?)";
		int codigo = 4;
		String nombre = "Pepito";
		String apellido1 = "Pésrez";
		String apellido2 = "González";
		LocalDate fechaNacimiento = LocalDate.of(2020, 1, 1);
		double salario = 3000.0;
		
		
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		if(conex!=null) {
			System.out.println("Conectado correctamente");
			try (PreparedStatement sentencia = conex.prepareStatement(query);){
				sentencia.setInt(1, codigo);
				sentencia.setString(2, nombre);
				sentencia.setString(3, apellido1);
				sentencia.setString(4, apellido2);
				sentencia.setDate(5, Date.valueOf(fechaNacimiento));
				sentencia.setDouble(6, salario);
				
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
