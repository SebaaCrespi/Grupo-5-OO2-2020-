package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Persona;
@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer>{
	
	/* SE USA PARA LA BASE DE DATOS POR ESO SE USA PERSONA? */
	
	public abstract Persona findById(int id);
	
	public abstract Persona findByNombre(String nombre);

	public abstract Persona findByApellido(String apellido);
	
	public abstract Persona findByFechaNacimiento(String fechaNacimiento);
	
	public abstract Persona findByDni(String dni);

}
