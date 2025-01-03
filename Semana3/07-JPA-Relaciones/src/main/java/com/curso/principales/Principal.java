package com.curso.principales;

import com.curso.model.Categoria;
import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Libro libro= new Libro("001", "Rayos y rallas", "Polo", 20);
		
		Categoria categoria = em.find(Categoria.class, "web");
		libro.setCategoria(categoria);
		em.persist(libro);
		em.getTransaction().commit();
		
		
	}
}