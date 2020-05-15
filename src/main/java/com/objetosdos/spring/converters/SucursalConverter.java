package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.models.SucursalModel;

@Component
public class SucursalConverter {
	
	public SucursalModel entityToModel(Sucursal sucursal) {
		return new SucursalModel(sucursal.getId(),sucursal.getUbicacion(),sucursal.getTelefono(),sucursal.getGerente());
		
	}

	
	public Sucursal modelToEntity(SucursalModel sucursalModel) {
		return new Sucursal 
				(sucursalModel.getId(),sucursalModel.getUbicacion(),sucursalModel.getTelefono(),sucursalModel.getGerente());
}
	
	
}
