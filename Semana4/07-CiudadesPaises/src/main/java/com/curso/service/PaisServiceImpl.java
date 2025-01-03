package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Pais;
import com.curso.repository.PaisRepository;
@Service
public class PaisServiceImpl implements PaisService {
	@Autowired
	PaisRepository paisRepository;
	@Override
	public List<Pais> getAllPaises() {
		return paisRepository.findAll();
	}

	@Override
	public Pais createPais(Pais pais) {
		return paisRepository.save(pais);
	}

}
