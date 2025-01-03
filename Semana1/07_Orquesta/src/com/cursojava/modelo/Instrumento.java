package com.cursojava.modelo;
/**
 * Clase que representa instrumentos musicales
 * 
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04 
 */
public abstract class Instrumento {
	public enum Tipo
	{
	    VIENTO, CUERDA, PERCUSION
	}
	protected String nombreInstrumento;
	protected Tipo tipo;
	
	public Instrumento(String nombreInstrumento, Tipo tipo) {
		super();
		this.nombreInstrumento = nombreInstrumento;
		this.tipo = tipo;
	}
	
	public void tocar() {
		System.out.println("Tocando el instrumento "+nombreInstrumento);
	}
	
	public void afinar() {
		System.out.println("Afinando el instrumento "+nombreInstrumento);
	}
	
}
