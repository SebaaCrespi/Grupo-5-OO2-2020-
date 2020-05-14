package com.objetosdos.spring.converters;

import com.objetosdos.spring.entities.Gerente;
import com.objetosdos.spring.models.GerenteModel;

import org.springframework.stereotype.Component;

@Component
public class GerenteConverter {
    public Gerente modelToEntity(GerenteModel gerentemodel) {
        return new Gerente(
            gerentemodel.getIdPersona(),
            gerentemodel.getNombre(),
            gerentemodel.getApellido(),
            gerentemodel.getFechaNacimiento(),
            gerentemodel.getDni(),
            gerentemodel.getHorasPorJornada(),
            gerentemodel.getSueldoBasico()
        );
	}
	public GerenteModel entityToModel(Gerente gerente) {
		return new GerenteModel(
            gerente.getIdPersona(),
            gerente.getNombre(),
            gerente.getApellido(),
            gerente.getFechaNacimiento(),
            gerente.getDni(),
            gerente.getHorasPorJornada(),
            gerente.getSueldoBasico()
        );
	}
}