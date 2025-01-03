package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/index")
	public String mostrarPrincipal() {
		return "principal";
	}
	
	@GetMapping("/home")
	public String mostrarHome(Model model) {
		model.addAttribute("mensaje", "Hola mundo");
		return "home";
	}
	@GetMapping("/unapag")
	public String mostrarUna() {
		return "una";
	}
	@GetMapping("/otrapag")
	public String mostrarOtra() {
		return "otra";
	}
}
