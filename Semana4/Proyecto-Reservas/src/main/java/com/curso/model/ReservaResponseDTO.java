package com.curso.model;

/**
 * La clase ReservaRequestDTO representa una {@link Reserva} siguiendo el patrón DTO.
 * Clase cuyas intancias se emplean en respuestas sobre reservas.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */

public class ReservaResponseDTO {
    private String nombreCliente;
    private String dni;
    private int idVuelo;

    public ReservaResponseDTO(String nombreCliente, String dni, int idVuelo) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.idVuelo = idVuelo;
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
    
    public int getIdVuelo() {
        return idVuelo;
    }
    
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
}