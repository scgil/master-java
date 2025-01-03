package com.curso.repositorio;

import java.util.List;

import com.curso.modelo.Pelicula;
/**
 * Interfaz para el repositorio de la entidad {@link Pelicula}.
 * Define los métodos CRUD que deben ser implementados para gestionar las peliculas en la base de datos.
 * @author Sergio Castro
 * @version 1.0 2024/12/23
 */
public interface IPeliculaRepository {
	
	public List<Pelicula> findAll();
	public List<Pelicula> findByDirectorNombre(String director);
	public List<Pelicula> findByDirectorLikeNombre(String texto);
	public List<Pelicula> findByDirectorIn(String director1, String director2);
	public List<Pelicula> findByPrecio(double precioMin, double precioMax);
	
}
