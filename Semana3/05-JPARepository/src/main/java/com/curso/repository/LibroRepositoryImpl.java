package com.curso.repository;

import java.util.List;

import com.curso.model.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación del repositorio para la entidad {@link Libro}.
 * Esta clase proporciona métodos para realizar operaciones CRUD en la base de datos
 * utilizando JPA.
 * @author Sergio Castro
 * @version 1.0 2024/12/23
 */
public class LibroRepositoryImpl implements ILibroRepository {

    
    private EntityManager entityManager;

    // Constructor donde se inyecta el EntityManager
    public LibroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }  

    // Guardar o actualizar un libro    
    
    @Transactional  //se usa para asegurar que las operaciones de persistencia se realizan 
    public Libro save(Libro libro) {
        if (entityManager.contains(libro) || libro.getIsbn() != null) {
            return entityManager.merge(libro);  // Si ya existe, hace un merge
        } else {
            entityManager.persist(libro);  // Si no existe, lo persiste
            return libro;
        }
    }


    // Obtener todos los libros
    public List<Libro> findAll() {
        return entityManager.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
    }
    
    // Obtener todos los libros de un mismo autor
    public List<Libro> findByAutor(String autor){
    	
    	TypedQuery<Libro> consulta = entityManager.createQuery("SELECT l FROM Libro l WHERE autor = :autor", Libro.class);
    	consulta.setParameter("autor", autor);
    	
    	List<Libro> libros = consulta.getResultList();
    	
    	return libros;
    }
    // Obtener todos los libros cuyo precio sea mayor que
    public List<Libro> findByPrecioGreaterThan(int precio){
    	TypedQuery<Libro> consulta = entityManager.createQuery("SELECT l FROM Libro l WHERE l.precio > :precio", Libro.class);
    	
    	consulta.setParameter("precio", precio);
    	
    	List<Libro> libros = consulta.getResultList();
    	
    	return libros;
    }
    
    // Eliminar libro por ISBN
    @Transactional
    public void deleteByIsbn(String isbn) {
    	
    	
    	Libro libro = entityManager.find(Libro.class, isbn);
    	
    	if (libro != null) {
    		entityManager.remove(libro);
    		System.out.println("Libro eliminado");
    	}else {
    		System.out.println("Libro no encontrado");
    	}
    	
    	
    }
    
    // Buscar libro por ISBN
    public Libro findByIsbn(String isbn) {
    	Libro libro = entityManager.find(Libro.class, isbn);
    	
    	return libro;
    }


}