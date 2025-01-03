package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Ciudad;
import com.curso.service.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public List<Ciudad> getAllCiudades() {
        return ciudadService.getAllCiudades();
    }

    @PostMapping
    public Ciudad createCiudad(@RequestBody Ciudad ciudad) {
        return ciudadService.createCiudad(ciudad);
    }
}

