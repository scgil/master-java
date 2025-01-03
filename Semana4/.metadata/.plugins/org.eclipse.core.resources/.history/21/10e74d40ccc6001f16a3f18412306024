package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.FormacionDTO;
import com.curso.service.FormacionService;
/**
 * Controlador REST para gestionar las formaciones.
 * Este controlador expone endpoints para obtener cursos y dar de alta nuevos cursos.
 * @author Sergio Castro
 * @version 1.0 2024/12/30
 */
@RestController
@RequestMapping("/formaciones")
public class FormacionController {

    @Autowired
    private FormacionService formacionService;

    @GetMapping()
    public List<FormacionDTO> listadoCursos() {

        return formacionService.cursos();

    }
    
    @PostMapping()
    public ResponseEntity<Void> altaCurso(@RequestBody FormacionDTO formacionDTO) {

    	boolean creado = formacionService.altaCurso(formacionDTO);

        if (creado) {

            return ResponseEntity.status(HttpStatus.CREATED).build();

        } else {

            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }

    }
}