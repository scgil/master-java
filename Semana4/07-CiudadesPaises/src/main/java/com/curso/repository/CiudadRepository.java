package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long>{

}
