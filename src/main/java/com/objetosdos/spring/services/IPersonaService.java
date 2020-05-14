package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Persona;
import com.objetosdos.spring.models.PersonaModel;



public interface IPersonaService {

	/* el service es con el modelo*/
	
	public List<Persona> getAll();
	
	public PersonaModel findById(int id);
	
	public PersonaModel findByName(String name);
	
	public PersonaModel insertOrUpdate(PersonaModel personModel);
	
	public boolean remove(int id);
	
	
	
	
	
}
