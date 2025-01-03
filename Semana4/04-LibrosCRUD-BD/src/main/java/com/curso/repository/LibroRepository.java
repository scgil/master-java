package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
	
	//Ejercicio para nosotros
	
	//Usando @Query --> permita buscar por 'titulo'
	@Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
	public Libro buscarLibroTitulo(String titulo);
	
	//Usando keywords --> buscar por 'tematica'
	public Libro findByTematica(String tematica);
}
