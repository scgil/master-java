package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.model.Todo;
import com.curso.service.TodoService;

@Controller
@RequestMapping("/todos")
public class TodoController {
	@Autowired
	private TodoService todoService;
	@GetMapping
	public String listTodos(Model model) {
		List<Todo> todos = todoService.getAllTodo();
		model.addAttribute("todos", todos);
		return "todo/list";
	}
	@PostMapping
	public String addTodo(@ModelAttribute Todo todo) {
		todoService.saveTodo(todo);
		return "redirect:/todos";
	}
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
		return "redirect:/todos";
	}
	
}
