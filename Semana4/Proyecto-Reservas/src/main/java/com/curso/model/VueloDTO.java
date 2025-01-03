package com.curso.model;

import java.time.LocalDate;

/**
 * La clase VueloDTO representa un Vuelo siguiendo el patrón DTO.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public class VueloDTO {

    private int idVuelo; 
    private String compania;
    private LocalDate fechaVuelo; 
    private double precio;
    private int plazasDisponibles;

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }
    
    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }
    public static VueloDTO encontrarVueloPorId(VueloDTO[] vueloDTO, int idVuelo) {
		int i = 0;
		boolean continuar = true;
		VueloDTO vuelo = null;
		
		while(i < vueloDTO.length && continuar) {
			if(vueloDTO[i].getIdVuelo() == idVuelo) {
				vuelo = vueloDTO[i];
				continuar = false;
			}
			i++;		
		}
		return vuelo;
		
	}

}

