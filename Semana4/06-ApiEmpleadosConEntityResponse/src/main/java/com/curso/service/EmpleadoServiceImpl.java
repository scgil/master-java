package com.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Empleado;
import com.curso.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> getAllEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado getEmpleadoById(Integer id) {
		//return empleadoRepository.findById(id).orElse(null);
		return empleadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: "+id));
	}

	@Override
	public Empleado crearEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado actualizarEmpleado(Integer id, Empleado empleado) {
		Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);

		if (empleadoExistente.isPresent()) {
			Empleado empleadoActualizar = empleadoExistente.get();
			empleadoActualizar.setNombre(empleado.getNombre());
			empleadoActualizar.setApellido(empleado.getApellido());
			empleadoActualizar.setEmail(empleado.getEmail());
			return empleadoRepository.save(empleadoActualizar);
		} else {
			throw new RuntimeException("Empleado no encontrado con id:" + id);					
		}
	}

	@Override
	public void eliminarEmpleado(Integer id) {
		Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
		if (empleadoExistente.isPresent()) {
			empleadoRepository.deleteById(id);
		}else {
			throw new RuntimeException("Empleado no encontrado con id:" + id);		
		}
	}

}
