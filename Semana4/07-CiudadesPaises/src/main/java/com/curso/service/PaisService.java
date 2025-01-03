package com.curso.service;

import java.util.List;

import com.curso.model.Pais;

public interface PaisService {
	List<Pais> getAllPaises();
	Pais createPais(Pais pais);
}
