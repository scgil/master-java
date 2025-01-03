package com.cursojava.modelo;

/**
 * Clase que representa un Ordenador
 * Permite crear objetos ordenador
 * @author Sergio Castro
 * @version 1.0 2024/12/05
 */

public class Ordenador extends Producto {
	
	String procesador;
	int memoria;
	int disco;

	public Ordenador(int id, String modelo, double precio, int cantidad, String procesador, int memoria, int disco) {
		super(id, modelo, precio, cantidad);
		this.procesador = procesador;
		this.memoria = memoria;
		this.disco = disco;
	
	}
	

}
