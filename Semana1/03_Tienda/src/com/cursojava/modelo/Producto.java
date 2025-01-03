package com.cursojava.modelo;

/**
 * Clase que representa un producto de la tienda
 * 
 * @author Sergio Castro
 * @version 1.0 2024/12/05
 */

public abstract class Producto {
	private int id;
	private String modelo;
	private double precio;
	private int cantidad;
	
	public Producto(int id, String modelo, double precio, int cantidad) {
		this.id = id;
		this.modelo = modelo;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	
	
	
	

}
