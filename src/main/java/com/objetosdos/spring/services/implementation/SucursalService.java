package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.DireccionConverter;
import com.objetosdos.spring.converters.SucursalConverter;
import com.objetosdos.spring.entities.Direccion;
import com.objetosdos.spring.entities.Gerente;
import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.models.DireccionModel;
import com.objetosdos.spring.models.SucursalModel;
import com.objetosdos.spring.repositories.IDireccionRepository;
import com.objetosdos.spring.repositories.ISucursalRepository;
import com.objetosdos.spring.services.ISucursalService;


@Service
public class SucursalService implements ISucursalService{
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private SucursalConverter sucursalConverter;
	
	
	

	@Override
	public List<Sucursal> getAll() {
		
		//Casteo de tipo Sucursal
		return (List<Sucursal>)sucursalRepository.findAll();
	}

	@Override
	public SucursalModel findById(int id) {
		
		System.out.println("EL ID DE SUCURSAL CUANDI BUSCA ES"+id);
		
		return sucursalConverter.entityToModel(sucursalRepository.findById(id));
	}

	@Override
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel) {
		
		Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
		
		return sucursalConverter.entityToModel(sucursal);
	}

	@Override
	public void delete(int id) {
		
		sucursalRepository.deleteById(id);
	}
	
}
