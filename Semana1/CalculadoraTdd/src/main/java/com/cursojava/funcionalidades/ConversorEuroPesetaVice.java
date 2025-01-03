package com.cursojava.funcionalidades;

public class ConversorEuroPesetaVice {
	private final double TIPO_CONVERSION = 166.386;;
	public double convertirEuroPeseta(double euros) {
		
		return euros*TIPO_CONVERSION;
	}
	public double convertirPesetaEuro(double pesetas) {
		
		return pesetas/TIPO_CONVERSION;

	}
	

}
