package com.curso.consultas;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Select10Object {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Object[]> consulta = em.createQuery("SELECT l.precio, COUNT(l.precio) FROM Libro l GROUP BY l.precio", Object[].class);
		List<Object[]> lista = consulta.getResultList();
		
		for(Object[] objeto: lista) {
			System.out.println("De "+ objeto[0]+" euros hay "+objeto[1] +" libros.");
		}
	}

}
