package com.curso.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Persona permite crear instancias de Personas
 * @author Sergio Castro
 * @version 1.0 2024/12/16
 */
public class Persona {

	private String nombre;
	private List<String> cursos;
	public Persona(String nombre) {
		this.nombre = nombre;
		this.cursos = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<String> getCursos() {
		return cursos;
	}
	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}
	
	public void insertarCurso(String curso) {
		cursos.add(curso);
	}
	
	

}
