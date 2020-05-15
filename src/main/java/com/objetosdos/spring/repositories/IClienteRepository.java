package com.objetosdos.spring.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Cliente;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Serializable>{
	
	public abstract Cliente findByIdPersona(int id);
	
	public abstract Cliente findByNombre(String nombre);

	public abstract Cliente findByApellido(String apellido);
	
	
	public abstract Cliente findByFechaNacimiento(String fechaNacimiento);
	
	public abstract Cliente findByDni(String dni);
	public abstract Cliente findByMail(String mail);

}
