package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.VendedorConverter;
import com.objetosdos.spring.entities.Gerente;
import com.objetosdos.spring.entities.Vendedor;
import com.objetosdos.spring.models.VendedorModel;
import com.objetosdos.spring.repositories.IVendedorRepository;
import com.objetosdos.spring.services.IVendedorService;

@Service
public class VendedorService implements IVendedorService{
	
	private IVendedorRepository vendedorRepository;
	private VendedorConverter vendedorConverter;

	@Override
	public List<Vendedor> getAll() {
		return vendedorRepository.findAll();
	}

	@Override
	public VendedorModel insertOrUpdate(VendedorModel vendedorModel) {
		Vendedor vendedor = vendedorRepository.save(vendedorConverter.modelToEntity(vendedorModel));
        return vendedorConverter.entityToModel(vendedor);
	}

	@Override
	public VendedorModel findByIdPersona(int id) {
		return vendedorConverter.entityToModel(vendedorRepository.findByIdPersona(id));
	}
	
	
	@Override
	 public boolean remove(int id) {
		try {
			vendedorRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		 
	 }
	

}
