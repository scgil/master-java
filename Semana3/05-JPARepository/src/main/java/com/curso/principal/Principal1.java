package com.curso.principal;

import java.util.List;

import com.curso.model.Libro;
import com.curso.repository.ILibroRepository;
import com.curso.repository.LibroRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Principal1 {

	public static void main(String[] args) {
        // Crear el EntityManagerFactory (esto carga la configuración de persistence.xml)
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");

        // Crear un EntityManager (esto es necesario para las operaciones de persistencia)
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Crear el repositorio, inyectando el EntityManager
        ILibroRepository libroRepository = new LibroRepositoryImpl(entityManager);
        

        // Crear un libro nuevo
        Libro libro = new Libro("1234567890", "El super Libro", "Juanito", 20);

        // Guardar el libro
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            libroRepository.save(libro);
            transaction.commit();
            System.out.println("Libro guardado: " + libro.getTitulo());
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        // Obtener el libro por ISBN
        Libro libroIsbn = libroRepository.findByIsbn("1234567890");
         
        if(libroIsbn != null) {
        	System.out.println(libroIsbn);
        }else {
        	System.out.println("Libro no encontrado");
        }
        

        // Obtener todos los libros
        List<Libro>libros = libroRepository.findAll();
        
        if(libros.size()>0) {
        	for (Libro l: libros) {
            	System.out.println(l);
            }
        }else {
        	System.out.println("No se han encontrado libros");
        }
        
        //Obtener libros por autor
        
        List<Libro> librosPorAutor = libroRepository.findByAutor("Juanito");
        if(librosPorAutor.size()>0) {
        	for (Libro l: librosPorAutor) {
            	System.out.println(l);
            }
        }else {
        	System.out.println("No se han encontrado libros por Autor");
        }
        
        //Obtener libros por precio
        List<Libro> librosPorPrecioMayorA = libroRepository.findByPrecioGreaterThan(10);
        if(librosPorPrecioMayorA.size()>0) {
        	for (Libro l: librosPorAutor) {
            	System.out.println(l);
            }
        }else {
        	System.out.println("No se han encontrado libros por Precio Mayor a.");
        }

        // Eliminar libro por ISBN
        EntityTransaction transaction1 = entityManager.getTransaction();
        try {
            transaction1.begin();
            libroRepository.deleteByIsbn("1234567890");
            transaction1.commit();
            System.out.println("Libro eliminado");
        } catch (RuntimeException e) {
            if (transaction1.isActive()) {
                transaction1.rollback();
            }
            e.printStackTrace();
        }
        
        
        
        // Cerrar el EntityManager y EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}