package com.curso.principal;

import java.util.List;
import java.util.Optional;

import com.curso.modelo.Comentario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repositorio.ComentarioRepositoryImpl;
import repositorio.IComentarioRepository;

public class Principal1 {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("periodico");
		EntityManager em = emf.createEntityManager();
		
		IComentarioRepository cr = new ComentarioRepositoryImpl(em);
		
		//Mostrar todos los comentarios
		System.out.println("Todos los comentarios:");
		List<Comentario> comentarios = cr.findAll();
		
		if(comentarios.size()>0) {
			for(Comentario c: comentarios) {
				System.out.println(c);
			}
		}else {
			System.out.println("No hay comentarios.");
		}
		
		//Mostrar comentarios por autor
		System.out.println("Comentarios por autor:");
		List<Comentario> comentariosAutor = cr.findByAutor("Forero 1");
		
		if(comentariosAutor.size()>0) {
			for(Comentario c: comentariosAutor) {
				System.out.println(c);
			}
		}else {
			System.out.println("No hay comentarios por autor.");
		}
		
		//Mostrar comentarios por Noticia
		System.out.println("Comentarios por Noticia:");
		Optional<List<Comentario>> comentariosOptional = cr.findComentariosByNoticia("Noticia 1");
		
		if (comentariosOptional.isPresent()) {

            List<Comentario> comentariosNoticia = comentariosOptional.get();

            for (Comentario c : comentariosNoticia) {

                System.out.println(c);

            }
		

		}else {
			System.out.println("No hay comentarios por noticia.");
		}
		
		

	}
	
	
	
	
}
