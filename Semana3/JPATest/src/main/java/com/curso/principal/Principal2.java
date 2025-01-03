package com.curso.principal;

import java.time.LocalDate;
import java.util.List;

import com.curso.modelo.Noticia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repositorio.INoticiaRepository;
import repositorio.NoticiaRepositoryImpl;

public class Principal2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("periodico");
		EntityManager em = emf.createEntityManager();
		
		INoticiaRepository nr = new NoticiaRepositoryImpl(em);
		//Mostrar todas las noticias
		System.out.println("Todas las noticias:");
		List<Noticia> noticias = nr.findAll();
		
		if(noticias.size()>0) {
			for(Noticia n: noticias) {
				System.out.println(n);
			}
		}else {
			System.out.println("No hay noticias.");
		}
		
		//Mostrar noticias por autor
		System.out.println("Noticias por autor:");
		List<Noticia> noticiasAutor = nr.findByAutor("Autor 2");
		
		if(noticiasAutor.size()>0) {
			for(Noticia n: noticiasAutor) {
				System.out.println(n);
			}
		}else {
			System.out.println("No hay noticias por autor.");
		}
		
		//Mostrar noticias por fecha
		System.out.println("Noticias por Fecha:");
		List<Noticia> noticiasFecha = nr.findByFecha(LocalDate.of(2024, 12, 25));
		
		if(noticiasFecha.size()>0) {
			for(Noticia n: noticiasFecha) {
				System.out.println(n);
			}
		}else {
			System.out.println("No hay noticias por Fecha.");
		}

	}

}
