package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Empleado;
import com.curso.service.EmpleadoService;

@RestController
@RequestMapping("api/empleados")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping
	public ResponseEntity<List<Empleado>> getAllEmpleados() {
		List<Empleado> empleados = empleadoService.getAllEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Integer id) {
		Empleado empleado = empleadoService.getEmpleadoById(id);
		return new ResponseEntity<>(empleado, empleado != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empleado) {
		Empleado empleadoCreado = empleadoService.crearEmpleado(empleado);
		return new ResponseEntity<>(empleadoCreado, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
		try {
			Empleado empleadoActualizado = empleadoService.actualizarEmpleado(id, empleado);
			return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmpleado(@PathVariable Integer id) {
		try {
			empleadoService.eliminarEmpleado(id);
			return new ResponseEntity<>("Empleado eliminado", HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	/*
	 	public ResponseEntity<Void> deleteEmpleado(@PathVariable Integer id) {
		try {
			empleadoService.eliminarEmpleado(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	 */

}
