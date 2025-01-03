package com.cursojava.modelo;

/**
 * Clase que representa el instrumento Guitarra Electrica
 * 
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04 
 */

public class GuitarraElectrica extends Guitarra {
	
	private int potencia;
	
	public GuitarraElectrica(String nombreInstrumento, Tipo tipo, int numCuerdas, int potencia) {
		super(nombreInstrumento, tipo, numCuerdas);
		this.potencia = potencia;
	}

	@Override
	public void tocar() {
		System.out.println("Tocando la guitarra eléctrica.");
	}
	

}
