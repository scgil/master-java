package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.model.Curso;

public class CursoService2 {
	public List<Curso> buscarTodos(){
		Curso c1 = new Curso("esperanto", 1);
		Curso c2 = new Curso("chino",3);
		Curso c3 = new Curso("japones", 2);
		
		List<Curso> listaCursos = new ArrayList<Curso>();
		
		listaCursos.add(c1);
		listaCursos.add(c2);
		listaCursos.add(c3);
		
		return listaCursos;
	}
}
