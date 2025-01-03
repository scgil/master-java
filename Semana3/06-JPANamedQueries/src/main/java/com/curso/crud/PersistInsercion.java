package com.curso.crud;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistInsercion {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");// referencia a la unidad de persistencia
		EntityManager em = emf.createEntityManager();
		
		Libro libro = new Libro("10A", "JSP", "Torquemada", 55);
		
		em.getTransaction().begin();
		
		em.persist(libro);	
		
		em.getTransaction().commit();
	}

}
