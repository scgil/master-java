package com.curso.consultas;

import java.util.List;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Select03WhereAnd {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Libro> consulta = em.createQuery("SELECT l FROM Libro l WHERE l.autor = :autor AND l.isbn=:isbn", Libro.class);
		consulta.setParameter("autor", "Juan");
		consulta.setParameter("isbn", "6A");
		
		List<Libro> libros = consulta.getResultList();
		
		for(Libro libro: libros) {
			System.out.println(libro);
		}

	}

}