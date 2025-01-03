package com.cursojava.modelo;

/**
 * Clase que representa una Arana
 * Crea objetos de tipo Arana
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */
public class Arana extends Animal {
	
	private static final int NUM_PATAS = 8; 
	
	public Arana() {
        super(NUM_PATAS);
    }

    @Override
    public void comer() {
        System.out.println("Las arañas comen mosquitos.");
    }
}
