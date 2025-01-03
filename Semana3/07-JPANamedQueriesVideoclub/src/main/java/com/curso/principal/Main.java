package com.curso.principal;

import java.util.List;

import com.curso.modelo.Pelicula;
import com.curso.repositorio.IPeliculaRepository;
import com.curso.repositorio.PeliculaRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		// Crear el EntityManagerFactory (esto carga la configuración de persistence.xml)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoclub");

        // Crear un EntityManager (esto es necesario para las operaciones de persistencia)
        EntityManager em = emf.createEntityManager();

        // Crear el repositorio, inyectando el EntityManager
        IPeliculaRepository libroRepository = new PeliculaRepositoryImpl(em);
        
		
		System.out.println("Todas las peliculas: ");
		List<Pelicula> peliculas1 = libroRepository.findAll();
		
		if(peliculas1.size()>0) {
			for(Pelicula p: peliculas1) {
				System.out.println(p);
			}
		}else {
			System.out.println("No se han encontrado peliculas");
		}
		
		System.out.println("Peliculas por nombre director: ");
		
		
		List<Pelicula> peliculas2 = libroRepository.findByDirectorNombre("Pepito");
		
		if(peliculas2.size()>0) {
			for(Pelicula p: peliculas2) {
				System.out.println(p);
			}
		}else {
			System.out.println("No se han encontrado peliculas");
		}
		
		System.out.println("Peliculas por nombre director Like: ");
		List<Pelicula> peliculas3 = libroRepository.findByDirectorLikeNombre("J%");
		
		if(peliculas3.size()>0) {
			for(Pelicula p: peliculas3) {
				System.out.println(p);
			}
		}else {
			System.out.println("No se han encontrado peliculas");
		}
		
		System.out.println("Peliculas por nombre director In: ");

		List<Pelicula> peliculas4 = libroRepository.findByDirectorIn("Pepito", "Juana");
		
		if(peliculas4.size()>0) {
			for(Pelicula p: peliculas4) {
				System.out.println(p);
			}
		}else {
			System.out.println("No se han encontrado peliculas");
		}
		
		System.out.println("Peliculas por precio:");
		
		List<Pelicula> peliculas5 = libroRepository.findByPrecio(2.50, 4.50);
		
		if(peliculas5.size()>0) {
			for(Pelicula p: peliculas5) {
				System.out.println(p);
			}
		}else {
			System.out.println("No se han encontrado peliculas");
		}
		
		em.close();
        emf.close();

	}

}
