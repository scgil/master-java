package com.cursojava.colegio.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.cursojava.colegio.Nota;

class NotaTest {

	@Test
	void testEsMismaAsignatura() {
		Nota nota1 = new Nota("lengua", 8);
		Nota nota2 = new Nota("lengua", 7);
		Nota nota3 = new Nota("sociales", 7);
		
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
