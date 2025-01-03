package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Libro;

@Service
public class LibrosServiceImpl implements LibrosService {
	
	public List<Libro> libros;
	public LibrosServiceImpl() {
		libros = new ArrayList<Libro>(List.of(new Libro(1, "Grecia", "guia viaje"),
				new Libro(2, "Atenas", "guia rapida"),
				new Libro(3, "Alemania", "guia extensa"),
				new Libro(4, "España", "guia detallada")));
	}
	@Override
	public List<Libro> libros() {
		
		return libros;
	}

	@Override
	public Libro buscarLibro(int isbn) {
		Libro libro = null;
			for(int i=0; i< libros.size(); i++) {
				if(libros.get(i).getIsbn()== isbn) {
					libro = libros.get(i);
					return libro;
				}
				
			}
		
		return libro;
	}

	@Override
	public void altaLibro(Libro libro) {
	if(libro != null) {
		libros.add(libro);
		
	}else {
		System.out.println("No se ha insertado libro.");
	}

	}

	@Override
	public void actualizar(Libro libro) {
		if(libro != null) {
			for(int i=0; i< libros.size(); i++) {
				if(libros.get(i).getIsbn()== libro.getIsbn()) {
					libros.get(i).setTematica(libro.getTematica());
					libros.get(i).setTitulo(libro.getTitulo());
				}
				
			}
		}else {
			System.out.println("No se ha actualizado el libro.");
		}

	}

	@Override
	public List<Libro> eliminarLibro(int isbn) {
		
			for(int i=0; i< libros.size(); i++) {
				if(libros.get(i).getIsbn()== isbn) {
					libros.remove(i);
					return libros;
				}	
			}
			return libros;
	}
}
