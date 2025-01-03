package com.cursojava.modelo;

/**
 * Clase que representa el instrumento Guitarra
 * 
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04 
 */

public abstract class Guitarra extends Instrumento {
	
	protected int numCuerdas;
	
	public Guitarra(String nombreInstrumento, Tipo tipo, int numCuerdas) {
		super(nombreInstrumento, tipo);
		this.numCuerdas = numCuerdas;
	}
	
	

}
