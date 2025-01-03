package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
