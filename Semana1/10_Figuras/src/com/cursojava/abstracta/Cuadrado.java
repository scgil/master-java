package com.cursojava.abstracta;

/**
 * Clase que representa un Cuadrado
 * Crea objetos de tipo Cuadrado
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}