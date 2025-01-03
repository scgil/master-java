package com.curso.dao;

import java.util.List;

import com.curso.modelo.Pelicula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * La clase PeliculaDAO sirve para realizar operaciones con la entidad Pelicula
 * @author Sergio Castro 
 * @version 1.0 2023/12/23
 */
public class PeliculaDAO implements IPelicula {

	public void findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p", Pelicula.class);
		List<Pelicula> peliculas = consulta.getResultList();
		
		for(Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		em.close();
        emf.close();

	}

	public void findByDirectorNombre() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.nombreDirector= :director", Pelicula.class);
		
		consulta.setParameter("director", "Pepito");
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		for(Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		em.close();
        emf.close();

	}

	public void findByDirectorLikeNombre() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.nombreDirector LIKE :director", Pelicula.class);
		
		consulta.setParameter("director", "P%");
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		for(Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		em.close();
        emf.close();

	}

	public void findByDirectorIn() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.nombreDirector IN(:director1, :director2)", Pelicula.class);
		
		consulta.setParameter("director1", "Pepito");
		consulta.setParameter("director2", "Juana");
		
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		for(Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		em.close();
        emf.close();
	}

	public void findByPrecio() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.precioAlquiler > :precioMin AND p.precioAlquiler < :precioMax", Pelicula.class);
		
		consulta.setParameter("precioMin", 2.0);
		consulta.setParameter("precioMax", 5.50);
		
		
		List<Pelicula> peliculas = consulta.getResultList();
		
		for(Pelicula pelicula: peliculas) {
			System.out.println(pelicula);
		}
		em.close();
        emf.close();

	}

}
