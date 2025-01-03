package com.cursojava.principal;

import com.cursojava.modelo.Libro;

public class Biblioteca {

	public static void main(String[] args) {
		Libro libro1 = new Libro(12345, "Harry Potter", "J.K.Rowling", 250);
		Libro libro2 = new Libro(67891, "El Señor de los Anillos", "Tolkien", 350);
		
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
		
		Libro.libroMasPaginas(libro1, libro2);

	}

}
