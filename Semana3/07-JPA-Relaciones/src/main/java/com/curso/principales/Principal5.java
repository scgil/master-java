package com.curso.principales;

import java.util.List;

import com.curso.model.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Principal5 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Categoria> consulta = em.createQuery("SELECT c FROM Categoria c WHERE SIZE(c.libros) < 3", Categoria.class);
		List<Categoria> categorias = consulta.getResultList();
		
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
		
	}
}