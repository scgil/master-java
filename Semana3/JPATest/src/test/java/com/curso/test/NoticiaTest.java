package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.modelo.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Pruebas unitarias para la clase @link{Noticia}
 * @author Sergio Castro
 * @version 1.0 2024/12/26
*/
class NoticiaTest {

	EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeEach
	void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("periodico");
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
	public void seleccionarNoticiaTest() {
		Noticia noticia = em.find(Noticia.class, "Noticia 1");
		assertEquals("Autor 1", noticia.getAutor());
	}
	
	@Test
	public void insertarNoticiaTest() {
		
		em.getTransaction().begin();
		
		Noticia noticia = new Noticia("Noticia 4", "Es navidad", LocalDate.of(2024, 12, 25));
		em.persist(noticia);
		
		em.getTransaction().commit();
		
		Noticia noticiaInsertada = em.find(Noticia.class, "Noticia 4");
		assertEquals("Noticia 4", noticiaInsertada.getTitulo());
		
	}
	@Test
	public void actualizarNoticiaTest() {
		Noticia noticia = em.find(Noticia.class, "Noticia 2");
		noticia.setAutor("Autor Test");
		noticia.setFecha(LocalDate.of(2024, 12, 31));
		
		em.merge(noticia);
		
		Noticia noticiaActualizada = em.find(Noticia.class, "Noticia 2");
		
        assertEquals("Autor Test", noticiaActualizada.getAutor());

        assertEquals(LocalDate.of(2024, 12, 31), noticiaActualizada.getFecha());
		
        
		
	}
	@Test
	public void borrarNoticiaTest() {
		Noticia noticia = em.find(Noticia.class, "Noticia 2");
		
		em.getTransaction().begin();
		
		em.remove(noticia);
		
		em.getTransaction().commit();
		
		Noticia noticiaBorrada = em.find(Noticia.class, "Noticia 2");
		assertNull(noticiaBorrada);
		
	}

}
