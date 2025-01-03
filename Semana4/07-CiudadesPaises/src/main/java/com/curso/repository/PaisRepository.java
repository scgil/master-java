package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}
