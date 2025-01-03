package com.curso.crud;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MergeActualizacion {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "5A");
		
		em.getTransaction().begin();
		
		libro.setAutor("Juanito");
		libro.setPrecio(45);
		em.merge(libro);

		em.getTransaction().commit();


	}

}
