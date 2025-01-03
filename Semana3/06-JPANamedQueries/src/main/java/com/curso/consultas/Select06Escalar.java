package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Select06Escalar {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<String> autor = em.createQuery("SELECT l.autor FROM Libro l", String.class);
		List<String> autores = autor.getResultList();
		for(String str : autores) {
			System.out.println(str);
		}
	}

}
