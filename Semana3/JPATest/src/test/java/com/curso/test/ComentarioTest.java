package com.curso.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.curso.modelo.Comentario;
import com.curso.modelo.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Pruebas unitarias para la clase @link{Comentario}
 * @author Sergio Castro
 * @version 1.0 2024/12/26
*/
class ComentarioTest {

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
	public void seleccionarComentarioTest() {
		Comentario comentario = em.find(Comentario.class, 1);
		assertEquals("Forero 1", comentario.getAutor());
	}
	
	@Test
	public void insertarComentarioTest() {
		
		em.getTransaction().begin();
		
		Noticia noticia = em.find(Noticia.class, "Noticia 3");
		Comentario comentario = new Comentario("Comentario 2 para Noticia 3", "Forero 4", noticia);
		
		em.persist(comentario);
		
		em.getTransaction().commit();
		
		Comentario comentarioInsertado = em.find(Comentario.class, 5);
		assertEquals(5, comentarioInsertado.getId());
		
	}
	@Test
	public void actualizarComentarioTest() {
		Comentario comentario = em.find(Comentario.class, 1);
		comentario.setAutor("Autor Test");
		comentario.setTexto("Texto Test");
		
		em.merge(comentario);
		
		Comentario comentarioActualizado = em.find(Comentario.class, 1);
		
        assertEquals("Autor Test", comentarioActualizado.getAutor());
        assertEquals("Texto Test", comentarioActualizado.getTexto());

		
        
		
	}
	@Test
	public void borrarComentarioTest() {
		Comentario comentario = em.find(Comentario.class, 2);
		
		em.getTransaction().begin();
		
		em.remove(comentario);
		
		em.getTransaction().commit();
		
		Comentario comentarioBorrado = em.find(Comentario.class, 2);
		assertNull(comentarioBorrado);
		
	}

}
