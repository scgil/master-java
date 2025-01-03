package com.cursojava.modelo;

/**
 * Clase que representa el instrumento Tambor
 * 
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04 
 */

public class Tambor extends Instrumento {
	
	String tamano;

	public Tambor(String nombreInstrumento, Tipo tipo, String tamano) {
		super(nombreInstrumento, tipo);
		this.tamano = tamano;
	}
	
	public void aporrear() {
		System.out.println("Aporreando tambor "+super.nombreInstrumento);
		
	}
}
