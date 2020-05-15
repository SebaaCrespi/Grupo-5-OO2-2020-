package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.PersonaConverter;
import com.objetosdos.spring.entities.Persona;
import com.objetosdos.spring.models.PersonaModel;
import com.objetosdos.spring.repositories.IPersonaRepository;
import com.objetosdos.spring.services.IPersonaService;


@Service
public class PersonaService  implements IPersonaService{
	
	@Autowired
	private IPersonaRepository personaRepository;

	@Autowired
 	private PersonaConverter personaConverter;

	@Override
	public PersonaModel findByIdPersona(int id) {
		return personaConverter.entityToModel(personaRepository.findById(id));
		
	}

	@Override
	public List<Persona> getAll() {     /* PORQUE ACA ES CON LA ENTIDAD?*/
		return personaRepository.findAll();
	}

	@Override
	public PersonaModel findByNombre(String nombre) {
		return personaConverter.entityToModel(personaRepository.findByNombre(nombre));
	}

	@Override
	public PersonaModel insertOrUpdate(PersonaModel personModel) {
		Persona person=  personaRepository.save(personaConverter.modelToEntity(personModel));// convierter el model a entidad y luego lo gurda
		return personaConverter.entityToModel(person); // Termina todos conviertiendo en modelo
	}

	@Override
	public boolean remove(int id) {
		try {
			personaRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}




	
	
	

}
