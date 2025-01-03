package com.cursojava.modelo;

import java.util.Objects;
/**
 * Clase que representa libros
 * 
 * @author Sergio Castro / ViewNext
 * @version 1.0, 2024/12/04
 */
public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private int numPaginas;
	/**
	 * Crea un libro a partir de sus atributos
	 * @param isbn identificador del libro
	 * @param titulo nombre del libro
	 * @param autor creador del libro
	 * @param numPaginas páginas del libro
	 */
	public Libro(int isbn, String titulo, String autor, int numPaginas) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public static void libroMasPaginas(Libro libro1, Libro libro2) {
		
		if(libro1.getNumPaginas() > libro2.getNumPaginas()) {
			System.out.println("El libro mayor es: " +libro1.toString());
		}else if(libro1.getNumPaginas() < libro2.getNumPaginas()) {
			System.out.println("El libro mayor es: " +libro2.toString());
		}else {
			System.out.println("Los libros tienen el mismo numero de paginas");
		}
	}
	
	@Override
	public String toString() {
		return "El libro con isbn " + isbn + " escrito por el autor " + autor + " tiene " + numPaginas;
	}
	@Override
	public int hashCode() {
		return Objects.hash(autor, isbn, numPaginas, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && isbn == other.isbn && numPaginas == other.numPaginas
				&& Objects.equals(titulo, other.titulo);
	}

}
