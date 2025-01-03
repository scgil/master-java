package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.FormacionDTO;
/**
 * Servicio para gestionar las formaciones.
 * Este servicio interactúa con el microservicio de "cursos" para obtener y crear cursos.
 * @author Sergio Castro
 * @version 1.0 2024/30/12
 */
@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	private RestTemplate template;
	private final String URL = "http://localhost:8080/cursos";
	@Override
	public List<FormacionDTO> cursos() {
		ResponseEntity<Curso[]> response = template.getForEntity(URL, Curso[].class);

        Curso[] cursos = response.getBody();


        List<FormacionDTO> formaciones = new ArrayList<>();

        for (Curso curso : cursos) {

            FormacionDTO formacion = new FormacionDTO();

            formacion.setCurso(curso.getNombre());

            formacion.setPrecio(curso.getPrecio());

            formacion.setAsignaturas(curso.getDuracion() >= 50.0 ? 10 : 5);

            formaciones.add(formacion);

        }

        return formaciones;
	}

	@Override
	public boolean altaCurso(FormacionDTO formacionDTO) {
		ResponseEntity<Curso[]> response = template.getForEntity(URL, Curso[].class);

        Curso[] cursos = response.getBody();

        for (Curso curso : cursos) {

            if (curso.getNombre().equals(formacionDTO.getCurso())) {

                return false; // No hacer nada si el curso ya existe

            }

        }



        // Crear un nuevo curso

        Curso nuevoCurso = new Curso();

        nuevoCurso.setNombre(formacionDTO.getCurso());

        nuevoCurso.setDuracion(formacionDTO.getAsignaturas() * 10);

        nuevoCurso.setPrecio(formacionDTO.getPrecio());



        Curso[] cursosActualizados = template.postForObject(URL, nuevoCurso, Curso[].class);
        
        return cursosActualizados != null;

	}

}
