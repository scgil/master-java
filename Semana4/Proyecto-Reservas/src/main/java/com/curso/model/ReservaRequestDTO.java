package com.curso.model;
/**
 * La clase ReservaRequestDTO representa una {@link Reserva} siguiendo el patrón DTO.
 * Clase cuyas instancias se emplean en peticiones de reserva.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
public class ReservaRequestDTO {

    private int idVuelo; 
    private int idHotel;
    private String nombreCliente;
    private String dni;
    private int totalPersonas;

    
    public ReservaRequestDTO(int idVuelo, int idHotel, String nombreCliente, String dni, int totalPersonas) {
		super();
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.totalPersonas = totalPersonas;
	}

	public int getIdVuelo() {
        return idVuelo;
    }
    
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
    
    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public int getTotalPersonas() {
        return totalPersonas;
    }
    
    public void setTotalPersonas(int totalPersonas) {
        this.totalPersonas = totalPersonas;
    }

}

