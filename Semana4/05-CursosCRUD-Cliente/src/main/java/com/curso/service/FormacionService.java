package com.curso.service;

import java.util.List;

import com.curso.model.FormacionDTO;

public interface FormacionService {
	
	public List<FormacionDTO> cursos();
	public boolean altaCurso(FormacionDTO formacionDTO);

}
