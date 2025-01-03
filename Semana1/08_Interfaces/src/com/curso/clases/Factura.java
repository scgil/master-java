package com.curso.clases;

import com.cursojava.interfaces.Imprimible;


public class Factura implements Imprimible {

	private int nFactura;

	private int codigoCliente;

	

	public Factura(int nFactura, int codigoCliente) {

		super();

		this.nFactura = nFactura;

		this.codigoCliente = codigoCliente;

	}



	@Override

	public void informeLargo() {

		System.out.println("informeLargo Factura "+ nFactura +" del cliente "+ codigoCliente);



	}



	@Override

	public void informeCorto() {

		System.out.println("informeLargo Factura "+ nFactura);



	}



}

