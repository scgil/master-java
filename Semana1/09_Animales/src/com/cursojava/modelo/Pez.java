package com.cursojava.modelo;

import com.cursojava.interfaces.Mascota;

/**
 * Clase que representa un Pez
 * Crea objetos de tipo Pez
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */
public class Pez extends Animal implements Mascota {
    private String nombre;
    private static final int NUM_PATAS = 0; 
    public Pez() {
        super(NUM_PATAS);
    }

    @Override
    public void andar() {
        System.out.println("En realidad no ando, nado.");
    }

    @Override
    public void comer() {
        System.out.println("Los peces comen plancton.");
    }

    @Override
    public void jugar() {
        System.out.println("Estoy nadando.");
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
