package com.cursojava.modelo;

import java.util.ArrayList;
import java.util.List;

import com.cursojava.interfaz.Conducible;

/**
 * Clase que representa un Camion
 * Clase que hereda de Vehiculo e implementa la interfaz Conducible
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */
public class Camion extends Vehiculo implements Conducible{
	
	private static final int NUM_RUEDAS = 4;

	List<Double> tacometro;
	
	public Camion(String matricula, String marca, String modelo, String color) {
		super(matricula, marca, modelo, color);
		tacometro = new ArrayList<>();
	}
	
	public int getNumeroRuedas() {
        return NUM_RUEDAS;
    }
	public void insertarVelocidad(double velocidad) {
		if(velocidad > 0.0) {
			tacometro.add(velocidad);
		}
		
	}
	/**
	 * Permite arrancar el camion
	 * Al arrancar, también se establece la hora de arranque
	 */
	@Override
    public void arrancar() {
        System.out.println("El camion está en marcha.");
        iniciarViaje();
        System.out.println("Tiempo inicial de viaje: " + getTiempoDeViaje().getSeconds() + " segundos.");
    }
	/**
	 * Permite desplazar el camion
	 * Desplaza el coche durante los metros indicados y actualiza el espacio recorrido y el tiempo debido al desplazamiento
	 * @param metros son los metros a recorrer
	 */
    @Override
    public void avanzar(int metros) {
        incrementarEspacioRecorrido(metros);
        actualizarTiempoActual();
        System.out.println("El camion avanza " + metros + " metros.");
        System.out.println("Tiempo actual de viaje: " + getTiempoDeViaje().getSeconds() + " segundos.");
        System.out.println("Velocidad: " + getVelocidad() + " m/s.");
    }

    /**
	 * Permite parar el camion
	 * Se actualiza el tiempo en el momento de parar
	 */
    @Override
    public void parar() {
        actualizarTiempoActual();
        System.out.println("El camion se ha detenido.");
        System.out.println("Tiempo final de viaje: " + getTiempoDeViaje().getSeconds() + " segundos.");
        System.out.println("Espacio recorrido: " + getEspacioRecorrido() + " metros.");
    }

}
