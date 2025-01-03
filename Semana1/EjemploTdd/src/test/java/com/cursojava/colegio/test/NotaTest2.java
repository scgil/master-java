package com.cursojava.colegio.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cursojava.colegio.Nota;

class NotaTest2 {
	
	Nota nota1 = null;
	Nota nota2 = null;
	Nota nota3 = null;
	Nota nota4 = null;
	Nota nota5 = null;
	
	@BeforeEach //@Before en JUnit4
	public void setUp() {
		nota1 = new Nota("lengua", 8);
		nota2 = new Nota("lengua", 7);
		nota3 = new Nota("sociales", 7);
		nota4 = new Nota("lengua", 8);
		nota5 = new Nota("lengua", 8);
	}
	
	
	@Test
	void testEsMismaAsignatura() {
		
		
		boolean esMisma = nota1.esMismaAsignatura(nota2);
		boolean esDistinta = nota1.esMismaAsignatura(nota3);
		assertTrue(esMisma);
		assertFalse(esDistinta);
		
	}
	
	@Test
	void testIgualdadNotas() {
		Nota nota1 = new Nota("lengua", 8);
		Nota nota2 = new Nota("lengua", 8);
		
		boolean iguales = nota1.equals(nota2);
		
		assertTrue(iguales);
		
	}
	
	@Test
	void testNoIgualdadNotas() {
		Nota nota1 = new Nota("lengua", 8);
		Nota nota2 = new Nota("sociales", 8);
		
		boolean noIguales = nota1.equals(nota2);
		
		assertFalse(noIguales);
		
	}
	
	@Test
	void notaNoEsComparableConOtraNotaTest() {
		Nota nota1 = new Nota("lengua", 8);
		Nota nota2 = new Nota("sociales", 7);
		
		assertThrows(RuntimeException.class, ()->nota1.esMayor(nota2));
		
	}

}
