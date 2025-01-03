package com.curso.service;

import java.util.List;

import com.curso.model.Empleado;

public interface EmpleadoService {
	List<Empleado> getAllEmpleados();
	Empleado getEmpleadoById(Integer id);
	Empleado crearEmpleado(Empleado empleado);
	Empleado actualizarEmpleado(Integer Id, Empleado empleado);
	void eliminarEmpleado(Integer id);
 
}
