package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.ClienteConverter;
import com.objetosdos.spring.entities.Cliente;
import com.objetosdos.spring.models.ClienteModel;
import com.objetosdos.spring.repositories.IClienteRepository;
import com.objetosdos.spring.repositories.IPersonaRepository;
import com.objetosdos.spring.services.IClienteService;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepo;

	@Autowired
	private IPersonaRepository personaRepo;

	@Autowired
	private ClienteConverter clienteConverter;

	@Override
	public List<Cliente> getAll() {

		return clienteRepo.findAll();
	}

	
	  @Override 
	  public ClienteModel findByIdPersona(int id) {
	 
	  return clienteConverter.entityToModel(clienteRepo.findByIdPersona(id)); // en repo esta como entidad, la busca y la // convierte en entidad. }
	 
	  }
	/*
	 * @Override public ClienteModel findByNombre(String nombre) {
	 * 
	 * return clienteConverter.entityToModel(clienteRepo.findByNombre(nombre)); }
	 * 
	 * @Override public ClienteModel findByApellido(String apellido) {
	 * 
	 * return clienteConverter.entityToModel(personaRepo.findByApellido(apellido));
	 * }
	 */
	@Override
	public ClienteModel insertOrUpdate(ClienteModel clienteModel) {
		Cliente cliente = clienteRepo.save(clienteConverter.ModelToEntity(clienteModel)); // de repo se guarda el
																							// cliente convertido en
																							// persona
		return clienteConverter.entityToModel(cliente); // se convierte en modelo la persona.
	}

	@Override
	public boolean remove(int id) {
		try {
			clienteRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public ClienteModel findByMail(String mail) {

		return clienteConverter.entityToModel(clienteRepo.findByMail(mail));

	}

}
