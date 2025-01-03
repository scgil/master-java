package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Curso;
/**
 * Implementación del servicio para la entidad {@link Curso}.
 * @author Sergio Castro
 * @version 1.0 2024/12/27
 */


@Service
public class CursoServiceImpl implements CursoService {
	
	public List<Curso> cursos;
	public CursoServiceImpl() {
		cursos = new ArrayList<Curso>(List.of(new Curso(1, "Programación I", 300.0, 1200.00),
				new Curso(2, "Programación II", 400.5, 1500.99),
				new Curso(3, "Algoritmos y Estructuras de Datos I", 350.5, 1300.50),
				new Curso(4, "Algoritmos y Estructuras de Datos II", 450, 1600.00)));
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		if(curso != null) {
			cursos.add(curso);
			
		}
		return cursos;
	}

	@Override
	public List<Curso> cursos() {
		
		return cursos;
	}

	@Override
	public List<Curso> eliminarCurso(int codCurso) {
		for(int i=0; i< cursos.size(); i++) {
			if(cursos.get(i).getCodCurso()== codCurso) {
				cursos.remove(i);
				return cursos;
			}	
		}
		return cursos;
	}

	@Override
	public void actualizarCurso(int codCurso, double duracion) {
			for(int i=0; i< cursos.size(); i++) {
				if(cursos.get(i).getCodCurso()== codCurso) {
					cursos.get(i).setDuracion(duracion);
					
				}		
			}
	}

	@Override
	public Curso buscarCurso(int codCurso) {
		Curso curso = null;
		for(int i=0; i< cursos.size(); i++) {
			if(cursos.get(i).getCodCurso()== codCurso) {
				curso = cursos.get(i);
				return curso;
			}
			
		}
	
	return curso;
	}

	@Override
	public List<Curso> cursosPorPrecio(double precioMin, double precioMax) {
		List<Curso> cursosPrecio = new ArrayList<>();
		
		for(Curso c: cursos) {
			if(c.getPrecio()>= precioMin && c.getPrecio()<= precioMax) {
				cursosPrecio.add(c);
			}
		}
		return cursosPrecio;
	}

}
