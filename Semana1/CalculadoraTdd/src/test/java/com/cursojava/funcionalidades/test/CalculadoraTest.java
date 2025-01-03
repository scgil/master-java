package com.cursojava.funcionalidades.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cursojava.funcionalidades.Calculadora;

class CalculadoraTest {
/*
	@Test
	void test() {
		fail("Not yet implemented");
	}
*/
	@Test
	@DisplayName("suma de dos números")
	void testSumar() {
		//Arrange---organizar
		Calculadora calculadora = new Calculadora();
		//Act-------ejecutar, actuar
		double sumarObtenido = calculadora.sumar(2.5, 4.5);
		//Assert----aseverar
		//   assertXX(valorEsperado, valorObtenido, diferenciaPermitida)
		double sumarEsperado = 7.0;
		assertEquals(sumarEsperado, sumarObtenido);
	}
	
	@Test
	@DisplayName("resta de dos números")
	void testRestar() {
		Calculadora calculadora = new Calculadora();
		double restarObtenido = calculadora.restar(5.0,1.0);
		double restarEsperado = 4.0;
		assertEquals(restarEsperado, restarObtenido);
	}
	
	@Test
	@DisplayName("multiplicar dos números")
	void testMultiplicar() {
		Calculadora calculadora = new Calculadora();
		double multiplicarObtenido = calculadora.multiplicar(2.0,3.0);
		double multiplicarEsperado = 6.0;
		assertEquals(multiplicarEsperado, multiplicarObtenido);
	}
	
	@Test
	@DisplayName("dividir dos números")
	void testDividir() {
		Calculadora calculadora = new Calculadora();
		double dividirObtenido = calculadora.dividir(10.133,5.0516);
		double dividirEsperado = 2.0;
		double diferenciaPermitida = 0.8;
		assertEquals(dividirEsperado, dividirObtenido, diferenciaPermitida);
	}
	
}
