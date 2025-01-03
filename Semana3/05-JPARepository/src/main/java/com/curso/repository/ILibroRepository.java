package com.curso.repository;

import java.util.List;

import com.curso.model.Libro;

/**
 * Interfaz para el repositorio de la entidad {@link Libro}.
 * Define los métodos CRUD que deben ser implementados para gestionar los libros en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/23
 */
public interface ILibroRepository {
	Libro save(Libro libro);	
	List<Libro> findAll();
	List<Libro> findByAutor(String autor);
	List<Libro> findByPrecioGreaterThan(int precio);
	void deleteByIsbn(String isbn);
	Libro findByIsbn(String isbn);
	
}
