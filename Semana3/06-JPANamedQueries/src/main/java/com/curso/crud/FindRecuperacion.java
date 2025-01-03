package com.curso.crud;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindRecuperacion {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		Libro libro = em.find(Libro.class, "5A");
		
		if(libro != null) {
			System.out.println(libro);
			
		}else {
			System.out.println("Libro no econtrado");
			
		}
	}

}
