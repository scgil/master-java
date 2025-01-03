package com.curso.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.curso.conexion.ConexionBD;
/**
 * La clase Delete representa las operaciones DELETE de base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/19
 */
public class Delete {
	
	

	public static void main(String[] args) {
		Connection conex = null;
		ConexionBD cbd = new ConexionBD();
		conex = cbd.conexion();
		
		String query1 = "DELETE FROM empleados WHERE codigo = ?";
		
		
		
		if(conex!=null) {
			deleteQuery1(conex, query1);
			
			
		}else {
			System.out.println("No se ha podido conectar con la BD");
		}

	}
	
	public static void deleteQuery1(Connection conex, String query) {
		try (PreparedStatement sentencia = conex.prepareStatement(query);){
			
			int codigo = 1;
			sentencia.setInt(1, codigo);
            int filas = sentencia.executeUpdate();

            if (filas > 0) {

                System.out.println("El empleado fue eliminado con exito.");
			}else {
				System.out.println("No se ha eliminado ningún empleado.");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		

}
