package com.objetosdos.spring.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.EmpleadoConverter;
import com.objetosdos.spring.entities.Empleado;
import com.objetosdos.spring.models.EmpleadoModel;

import java.util.List;

import com.objetosdos.spring.repositories.IEmpleadoRepository;
import com.objetosdos.spring.services.IEmpleadoService;


@Service
public class EmpleadoService implements IEmpleadoService {
	
	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Autowired
	private EmpleadoConverter empleadoConverter;

	@Override
	public List<Empleado> getAll(){     /* PORQUE ACA ES CON LA ENTIDAD?*/
		return empleadoRepository.findAll();
	}
	@Override
	public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel) {
		Empleado empleado = empleadoRepository.save(empleadoConverter.modelToEntity(empleadoModel));// convierter el model a entidad y luego lo gurda
		return empleadoConverter.entityToModel(empleado); // Termina todos conviertiendo en modelo
	}

}
