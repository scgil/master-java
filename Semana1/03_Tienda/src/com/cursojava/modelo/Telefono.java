package com.cursojava.modelo;

/**
 * Clase que representa un telefono
 * Permite crear objetos Telefono
 * @author Sergio Castro
 * @version 1.0 2024/12/05
 */

public class Telefono extends Producto {
	
	private String operador;

	public Telefono(int id, String modelo, double precio, int cantidad, String operador) {
		super(id, modelo, precio, cantidad);
		this.operador = operador;
		
	}

}
