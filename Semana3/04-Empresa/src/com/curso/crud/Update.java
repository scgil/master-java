package com.curso.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.curso.conexion.ConexionBD;

/**
 * La clase Update representa las operaciones UPDATE de base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class Update {
	
	

	public static void main(String[] args) {
		Connection conex = null;
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		String query1 = "UPDATE empleados SET nombre = ?, apellido1 = ?, apellido2 = ?, fecha_nacimiento = ?, salario = ? WHERE codigo = ?";
		
		
		
		if(conex!=null) {
			actualizarQuery1(conex, query1);
			
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}
	
	public static void actualizarQuery1(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			int codigo = 1;
			String nombre = "Carlos";
            String apellido1 = "López";
            String apellido2 = "Martínez";
            LocalDate fechaNacimiento = LocalDate.of(1985, 5, 15);
            double salario = 35000.00;
            
            
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido1);
            sentencia.setString(3, apellido2);
            sentencia.setDate(4, Date.valueOf(fechaNacimiento));
            sentencia.setDouble(5, salario);
            sentencia.setInt(6, codigo);
            int filas = sentencia.executeUpdate();

            if (filas > 0) {

                System.out.println("El registro del empleado fue actualizado exitosamente");

            }else {
            	System.out.println("El registro no se ha actualizado");
            }
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}