package com.cursojava.modelo;

import com.cursojava.interfaz.Conducible;

/**
 * Clase que representa un Coche
 * Clase que hereda de Vehiculo e implementa la interfaz Conducible
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */

public class Coche extends Vehiculo implements Conducible{
	
	private static final int NUM_RUEDAS = 4;

	public Coche(String matricula, String marca, String modelo, String color) {
		super(matricula, marca, modelo, color);

	}
	
	public int getNumeroRuedas() {
        return NUM_RUEDAS;
    }
	/**
	 * Permite arrancar el coche
	 * Al arrancar, también se establece la hora de arranque
	 */
	@Override
    public void arrancar() {
        System.out.println("El coche está en marcha.");
        iniciarViaje();
        System.out.println("Tiempo inicial de viaje: " + getTiempoDeViaje().getSeconds() + " segundos.");
    }
	/**
	 * Permite desplazar el coche
	 * Desplaza el coche durante los metros indicados y actualiza el espacio recorrido y el tiempo debido al desplazamiento
	 * @param metros son los metros a recorrer
	 */
    @Override
    public void avanzar(int metros) {
        incrementarEspacioRecorrido(metros);
        actualizarTiempoActual();
        System.out.println("El coche avanza " + metros + " metros.");
        System.out.println("Tiempo actual de viaje: " + getTiempoDeViaje().getSeconds() + " segundos.");
        System.out.println("Velocidad: " + getVelocidad() + " m/s.");
        
    }

    /**
	 * Permite parar el coche
	 * Se actualiza el tiempo en el momento de parar
	 */
    @Override
    public void parar() {
        actualizarTiempoActual();
        System.out.println("El coche se ha detenido.");
        System.out.println("Tiempo final de viaje: " + getTiempoDeViaje().getSeconds() + " segundos.");
        System.out.println("Espacio recorrido: " + getEspacioRecorrido() + " metros.");
    }
    

}
