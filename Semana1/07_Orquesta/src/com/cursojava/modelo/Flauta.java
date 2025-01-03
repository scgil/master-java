package com.cursojava.modelo;

/**
 * Clase que representa el instrumento Flauta
 * 
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04 
 */

public class Flauta extends Instrumento {
	
	String modelo;
	
	public Flauta(String nombreInstrumento, Tipo tipo, String modelo) {
		super(nombreInstrumento, tipo);
		this.modelo = modelo;
	}

	@Override
	public void tocar() {
		super.tocar();
		System.out.println("Soplando");
	}
	

}
