package com.cursojava.modelo;

import java.time.Duration;

import java.time.LocalTime;

/**
 * Clase que representa un Vehiculo
 * Es una superclase de la que pueden heredar distintos vehiculos
 * @author Sergio Castro
 * @version 1.0 2024/12/10
 */

public abstract class Vehiculo {
    protected final String matricula;
    protected String marca;
    protected String modelo;
    protected String color;
    protected int espacioRecorrido;
    protected LocalTime tiempoInicio;
    protected LocalTime tiempoActual;

    public Vehiculo(String matricula, String marca, String modelo, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.espacioRecorrido = 0;
    }

    public String getMatricula() {
        return matricula;
    }
    
    public String getMarca() {
    	return marca;
    }
    public String getModelo() {
    	return modelo;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEspacioRecorrido() {
        return espacioRecorrido;
    }
    /**
     * Incrementa el espacio recorrido en metros
     * Permite actualizar la propiedad espacioRecorrido
     * @param metros que se han recorrido en un trayeto
     */
    public void incrementarEspacioRecorrido(int metros) {
        this.espacioRecorrido += metros;
    }
    /**
     * Establece el tiempo al inicio del viaje
     * Permite establecer el momento de tiempo al inicio del viaje (Hora, minuto, segundo)
     */
    public void iniciarViaje() {
        this.tiempoInicio = LocalTime.now();
        this.tiempoActual = tiempoInicio;
    }
    /**
     * Establece el tiempo actual
     * Permite establecer el momento de tiempo actual (Hora, minuto, segundo)
     */
    public void actualizarTiempoActual() {
    	this.tiempoActual = LocalTime.now();
        
    }
    /**
     * Calcula el tiempo de viaje
     * Permite establecer la diferencia entre tiempo el tiempo actual y el inicial
     */
    public Duration getTiempoDeViaje() {
        if (tiempoInicio != null && tiempoActual != null) {
            return Duration.between(tiempoInicio, tiempoActual);
        } else {
            return Duration.ZERO;
        }
    }
    /**
     * Calcula la velocidad
     * Permite calcular la velocidad como espacio/tiempo (m/s)
     * @return
     */
    public double getVelocidad() {
        Duration duracion = getTiempoDeViaje();
        if (!duracion.isZero()) {
            return (double) espacioRecorrido / duracion.getSeconds();
        } else {
            return 0;
        }
    }
    
	public String mostrarDatos() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ "]";
	}

  
}
