package com.curso.repositorio;

import java.util.List;

import com.curso.modelo.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 * Implementación del repositorio para la entidad {@link Pelicula}.
 * Esta clase proporciona métodos para realizar operaciones CRUD en la base de datos
 * utilizando JPA.
 * @author Sergio Castro
 * @version 1.0 2024/12/23
 */
public class PeliculaRepositoryImpl implements IPeliculaRepository {
	
	private EntityManager em;

    // Constructor donde se inyecta el EntityManager
    public PeliculaRepositoryImpl(EntityManager entityManager) {
        this.em = entityManager;
    }  

	public List<Pelicula> findAll() {
		
		
		TypedQuery<Pelicula> consulta = em.createNamedQuery("Pelicula.buscarTodas", Pelicula.class);
		List<Pelicula> peliculas = consulta.getResultList();
		
		return peliculas;

	}

	public List<Pelicula> findByDirectorNombre(String director) {
		
		TypedQuery<Pelicula> consulta = em.createNamedQuery("Pelicula.buscarPorNombreDirector", Pelicula.class);
		
		consulta.setParameter("director", director);
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		return peliculas;

	}

	public List<Pelicula> findByDirectorLikeNombre(String texto) {
		
		TypedQuery<Pelicula> consulta = em.createNamedQuery("Pelicula.buscarPorNombreDirectorLike", Pelicula.class);
		
		consulta.setParameter("director", texto);
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		return peliculas;
		

	}

	public List<Pelicula> findByDirectorIn(String director1, String director2) {
		
		TypedQuery<Pelicula> consulta = em.createNamedQuery("Pelicula.buscarPorNombreDirectorIn", Pelicula.class);
		
		consulta.setParameter("director1", director1);
		consulta.setParameter("director2", director2);
			
		List<Pelicula> peliculas = consulta.getResultList();
		return peliculas;
	}

	public List<Pelicula> findByPrecio(double precioMin, double precioMax) {
		
		TypedQuery<Pelicula> consulta = em.createNamedQuery("Pelicula.buscarPorPrecioEntre", Pelicula.class);
		
		consulta.setParameter("precioMin", precioMin);
		consulta.setParameter("precioMax", precioMax);
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		return peliculas;
	}

}
