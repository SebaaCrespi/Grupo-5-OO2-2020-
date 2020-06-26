package com.objetosdos.spring.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.models.SucursalModel;
import com.objetosdos.spring.repositories.ISucursalRepository;

@Component
public class SucursalConverter {
	
	@Autowired
	private DireccionConverter direccionConverter;
	@Autowired
	private GerenteConverter gerenteConverter;
	@Autowired
	private ISucursalRepository sucursalRepository;

	public SucursalModel entityToModel(Sucursal sucursal) {
		return new SucursalModel(
			sucursal.getId(),
			direccionConverter.entityToModel(sucursal.getUbicacion()),
			sucursal.getTelefono(),
			gerenteConverter.entityToModel(sucursal.getGerente())
		);
	}
	public Sucursal modelToEntityWithId(SucursalModel sucursalModel){
		return sucursalRepository.findById(sucursalModel.getId());
	}		
	public Sucursal modelToEntity(SucursalModel sucursalModel) {
		return new Sucursal(
			sucursalModel.getId(),
			direccionConverter.modelToEntity(sucursalModel.getUbicacion()),
			sucursalModel.getTelefono(),
			gerenteConverter.modelToEntity(sucursalModel.getGerente())
		);
		
	}
		


}