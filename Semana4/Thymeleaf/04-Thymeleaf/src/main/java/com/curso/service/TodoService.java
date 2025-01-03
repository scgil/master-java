package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Todo;
import com.curso.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	public List<Todo> getAllTodo(){
		return todoRepository.findAll();
	}
	
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
}
