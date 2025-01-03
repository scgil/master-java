package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class LibroTest {
	EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("biblioteca");
		em = emf.createEntityManager();
	}

	@Test
	public void entityFactoryManagerTest() {
		assertNotNull(emf);
	}
	
	@Test
	public void entityManagerTest() {
		assertNotNull(em);
	}
	
	@Test
	public void seleccionarLibroTest() {
		Libro libro = em.find(Libro.class, "1AB");
		assertEquals("pepito", libro.getAutor());
	}
	
	@Test
	public void insertarLibroTest() {
		
		em.getTransaction().begin();
		
		Libro libro = new Libro("ZZZ", "Que sueño", "Dormilon", 40);
		em.persist(libro);
		
		em.getTransaction().commit();
		
		Libro libroInsertado = em.find(Libro.class, "ZZZ");
		assertEquals("ZZZ", libroInsertado.getIsbn());
		
	}
	
	@Test
	public void borrarLibroTest() {
		Libro libro = em.find(Libro.class, "1AB");
		
		em.getTransaction().begin();
		
		em.remove(libro);
		
		em.getTransaction().commit();
		
		Libro libroBorrado = em.find(Libro.class, "1AB");
		assertNull(libroBorrado);
		
	}

}
