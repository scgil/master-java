package com.cursojava.modelo;

/**
 * Clase que representa un Animal
 * Crea objetos de tipo Animal
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */

public abstract class Animal {
	protected int numeroPatas;

    public Animal(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    public void andar() {
        System.out.println("Este animal anda sobre " + numeroPatas + " patas.");
    }

    public abstract void comer();
}