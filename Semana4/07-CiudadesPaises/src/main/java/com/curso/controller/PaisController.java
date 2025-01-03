package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pais;
import com.curso.service.PaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
	
    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisService.getAllPaises();
    }

    @PostMapping
    public Pais createCountry(@RequestBody Pais pais) {
        return paisService.createPais(pais);
    }

}
