package com.curso.principal;

import java.util.List;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Principal {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("nombre");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Libro> consulta1 = em.createNamedQuery("Libro.buscarTodos", Libro.class);
		
		List<Libro> libros = consulta1.getResultList();
		
		if(libros.size()>0) {
			for(Libro l: libros) {
				System.out.println(l);
			}
		}else {
			System.out.println("No se han encontrado libros");
		}
	}

}
