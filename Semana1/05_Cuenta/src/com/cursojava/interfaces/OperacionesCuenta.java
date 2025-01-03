package com.cursojava.interfaces;

import com.cursojava.excepciones.CuentaException;

public interface OperacionesCuenta {
	public void ingresar(double cantidad)throws CuentaException;
	public void retirar(double cantidad)throws CuentaException;

}