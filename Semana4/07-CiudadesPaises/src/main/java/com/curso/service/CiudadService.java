package com.curso.service;

import java.util.List;

import com.curso.model.Ciudad;

public interface CiudadService {
	List<Ciudad> getAllCiudades(); 
	Ciudad createCiudad(Ciudad ciudad);
}
