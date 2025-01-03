package com.cursojava.excepciones;

public class CuentaException extends Exception{
	private int codigoError;
	
	public CuentaException(int codigoError) {
		super();
		this.codigoError = codigoError;
	}
	@Override
	public String getMessage() {
		String mensaje;
		switch (codigoError) {
        case 111:
        	mensaje = "La cuenta está bloqueada. No se pueden realizar operaciones.";
        	break;
        case 222:
            mensaje = "Fondos insuficientes. La cuenta está en números rojos.";
            break;
        case 333:
            mensaje = "La cuenta está operativa.";
            break;
        case 444:
            mensaje = "Valor introducido incorrecto.";
            break;
        default:
            mensaje = "Error desconocido.";
		}
		
		return mensaje;
		
	}

}
