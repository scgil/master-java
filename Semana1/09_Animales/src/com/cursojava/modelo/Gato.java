package com.cursojava.modelo;

import com.cursojava.interfaces.Mascota;

/**
 * Clase que representa un Gato
 * Crea objetos de tipo Gato
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */

public class Gato extends Animal implements Mascota {
	private static final int NUM_PATAS = 4; 
	private String nombre;

    public Gato() {
        super(NUM_PATAS);
    }

    @Override
    public void comer() {
        System.out.println("A los gatos les gusta comer peces y arañas.");
    }

    @Override
    public void jugar() {
        System.out.println("A " + nombre + " le gusta jugar con pelotas.");
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
