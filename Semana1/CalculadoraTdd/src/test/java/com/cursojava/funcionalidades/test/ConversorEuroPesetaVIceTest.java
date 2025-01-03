package com.cursojava.funcionalidades.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cursojava.funcionalidades.ConversorEuroPesetaVice;

class ConversorEuroPesetaVIceTest {

	@Test
	@DisplayName("Conversión Euro a Peseta")
	void testConvertirEuroPeseta() {
		ConversorEuroPesetaVice convertirEuroPeseta = new ConversorEuroPesetaVice();
		double tipoConversion = 166.386;
		double euros = 2.0;
		double esperado = euros*tipoConversion;
		double obtenido = convertirEuroPeseta.convertirEuroPeseta(euros);
		assertEquals(esperado, obtenido);
	}
	@Test
	@DisplayName("Conversión Peseta a Euro")
	void testConvertirPesetaEuro() {
		ConversorEuroPesetaVice convertirEuroPeseta = new ConversorEuroPesetaVice();
		double tipoConversion = 166.386;
		double pesetas = 100.0;
		double esperado = pesetas/tipoConversion;
		double obtenido = convertirEuroPeseta.convertirPesetaEuro(pesetas);
		assertEquals(esperado, obtenido);
	}

}
