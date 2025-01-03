package com.cursojava.interfaces;

/**
 * Clase que representa un Rectangulo
 * Crea objetos de tipo Rectangulo
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */
public class Rectangulo implements Figura{
	private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }

}
