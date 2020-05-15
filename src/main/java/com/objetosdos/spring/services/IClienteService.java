package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Cliente;
import com.objetosdos.spring.entities.Persona;
import com.objetosdos.spring.models.ClienteModel;
import com.objetosdos.spring.models.PersonaModel;

public interface IClienteService {

	public List<Cliente> getAll();  // porque la entidad?
	
	public ClienteModel findByIdPersona(int id);
	
	//public PersonaModel findByNombre(String nombre);
	public ClienteModel findByMail(String mail);
	
	public ClienteModel insertOrUpdate(ClienteModel clienteModel);
	
	public boolean remove(int id);
	
	
}
