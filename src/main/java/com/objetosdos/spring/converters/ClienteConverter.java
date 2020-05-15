package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Cliente;
import com.objetosdos.spring.models.ClienteModel;
import com.objetosdos.spring.models.PersonaModel;


@Component
public class ClienteConverter extends PersonaConverter{
	
	public ClienteModel entityToModel(Cliente cliente) {
	return  new ClienteModel (cliente.getIdPersona(),cliente.getNombre(),cliente.getApellido(),cliente.getFechaNacimiento(),cliente.getDni(),cliente.getMail());
		
	}

	
	public Cliente ModelToEntity(ClienteModel clienteModel) {
		return  new Cliente (clienteModel.getIdPersona(),clienteModel.getNombre(),clienteModel.getApellido(),clienteModel.getFechaNacimiento(),clienteModel.getDni(),clienteModel.getMail());
			
		}
}
