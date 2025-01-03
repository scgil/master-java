package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Ciudad;
import com.curso.repository.CiudadRepository;
@Service
public class CiudadServiceImpl implements CiudadService {
	@Autowired
	private CiudadRepository ciudadRepository;
	@Override
	public List<Ciudad> getAllCiudades() {
		return ciudadRepository.findAll();
	}

	@Override
	public Ciudad createCiudad(Ciudad ciudad) {
		return ciudadRepository.save(ciudad);
	}

}
