package com.objetosdos.spring.converters;

import com.objetosdos.spring.entities.Empleado;
import com.objetosdos.spring.models.EmpleadoModel;

import org.springframework.stereotype.Component;

@Component
public class EmpleadoConverter {
    public Empleado modelToEntity(EmpleadoModel empleadomodel) {
        return new Empleado(
            empleadomodel.getIdPersona(),
            empleadomodel.getNombre(),
            empleadomodel.getApellido(),
            empleadomodel.getFechaNacimiento(),
            empleadomodel.getDni(),
            empleadomodel.getHorasPorJornada(),
            empleadomodel.getSueldoBasico()
        );
	}
	public EmpleadoModel entityToModel(Empleado empleado) {
		return new EmpleadoModel(
            empleado.getIdPersona(),
            empleado.getNombre(),
            empleado.getApellido(),
            empleado.getFechaNacimiento(),
            empleado.getDni(),
            empleado.getHorasPorJornada(),
            empleado.getSueldoBasico()
        );
	}
}