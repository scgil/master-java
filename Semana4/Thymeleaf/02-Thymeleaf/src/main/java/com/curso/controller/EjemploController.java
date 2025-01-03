package com.curso.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EjemploController {
	@GetMapping({"/","/bienvenida"})
	public String index(Model model) {
		model.addAttribute("nombre", "Pepito");
		
		model.addAttribute("frutas", List.of("Plátano", "Cerezas","Naranjas"));
		
		return "index";
	}
	
}
