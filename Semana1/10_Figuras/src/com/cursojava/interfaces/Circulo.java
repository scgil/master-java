package com.cursojava.interfaces;

/**
 * Clase que representa un Circulo
 * Crea objetos de tipo Circulo
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */
public class Circulo implements Figura {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}
