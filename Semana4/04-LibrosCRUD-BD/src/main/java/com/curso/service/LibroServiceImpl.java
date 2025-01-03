package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Libro;
import com.curso.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {
	@Autowired
	LibroRepository repository;

	@Override
	public List<Libro> libros() {
		
		return repository.findAll();
	}

	@Override
	public Libro buscarLibro(int isbn) {	
		return repository.findById(isbn).orElse(null);
	}

	@Override
	public void altaLibro(Libro libro) {
		repository.save(libro);

	}

	@Override
	public void actualizar(Libro libro) {
		repository.save(libro);

	}

	@Override
	public List<Libro> eliminarLibro(int isbn) {
		repository.deleteById(isbn);
		return repository.findAll();
	}
	@Override
	public Libro buscarLibroTitulo(String titulo) {
		if(titulo != null) {
			return repository.buscarLibroTitulo(titulo);
		}else {
			return null;
		}
	}
	@Override
	public Libro findByTematica(String tematica) {
		if(tematica != null) {
			return repository.findByTematica(tematica);
		}else {
			return null;
		}
	}

}
