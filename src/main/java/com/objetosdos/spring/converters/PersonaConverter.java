package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Persona;
import com.objetosdos.spring.models.PersonaModel;

@Component
public class PersonaConverter {
	
	public Persona modelToEntity(PersonaModel personmodel) {
		return new Persona (
			personmodel.getIdPersona(),
			personmodel.getNombre(),
			personmodel.getApellido(),
			personmodel.getFechaNacimiento(),
			personmodel.getDni()
		);
	}
	public PersonaModel entityToModel(Persona persona) {
		return new PersonaModel(
			persona.getIdPersona(),
			persona.getNombre(),
			persona.getApellido(),
			persona.getFechaNacimiento(),persona.getDni()
		);
	}
}
