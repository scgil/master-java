package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
