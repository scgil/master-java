package com.cursojava.modelo;

import com.cursojava.excepciones.CuentaException;
import com.cursojava.interfaces.OperacionesCuenta;

/**
 * Clase que representa una cuenta bancaria
 * Permite crear cuentas y gestionarlas
 * @author Sergio Castro
 * @version 1.0 2024/12/05
 */


public class Cuenta implements OperacionesCuenta {
	public enum Estado {
	    OPERATIVA,
	    BLOQUEADA,
	    NUMEROS_ROJOS
	}
	
	private String titular;
	private double cantidad;
	private Estado estado;
	

	public Cuenta(String titular) {
		this.titular = titular;
		this.estado = Estado.OPERATIVA;
		
	}

	
	public Cuenta(String titular, double cantidad) {

		this(titular);
		this.cantidad = cantidad;
	}
	
	public String getTitular() {
		return titular;
	}


	public void setTitular(String titular) {
		this.titular = titular;
	}


	public double getCantidad() {
		return cantidad;
	}


	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	@Override
	public void ingresar(double cantidad) throws CuentaException {
		if(getEstado()== Estado.BLOQUEADA) {
			throw new CuentaException(111);
		} else if(cantidad <= 0) {
			throw new CuentaException(444);
		}else {
			double saldoFinal = this.cantidad+cantidad;
			setCantidad(saldoFinal);
		}

	}

	@Override
	public void retirar(double importe) throws CuentaException {
		double saldoFinal = this.cantidad - importe;
		if(estado== Estado.BLOQUEADA) {
			throw new CuentaException(111);
		} else if(estado== Estado.NUMEROS_ROJOS) {
			throw new CuentaException(222);
		}else if(importe <= 0) {
			throw new CuentaException(444);
		}else if (saldoFinal<0){	
			setEstado(Estado.NUMEROS_ROJOS);
			setCantidad(saldoFinal);
		} else {
			setCantidad(saldoFinal);
		}
	}
}
