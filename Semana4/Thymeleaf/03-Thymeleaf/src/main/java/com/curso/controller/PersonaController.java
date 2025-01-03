package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.curso.service.PersonaService;

@Controller
public class PersonaController {
	@Autowired
	PersonaService service;
	
	@GetMapping("/personas/lista")
	public String mostrarPersonas() {
		return "personas/lista";
	}
	
	@GetMapping("/personas/lista2")
	public String mostrarPersonas2(Model model) {
		model.addAttribute("lista", service.buscarTodas());
		return "personas/lista2";
	}
	
}
