package com.objetosdos.spring.converters;

import com.objetosdos.spring.entities.Direccion;
import com.objetosdos.spring.models.DireccionModel;

import org.springframework.stereotype.Component;

@Component
public class DireccionConverter {
	
	public  DireccionModel entityToModel(Direccion direccion) {
		return new DireccionModel(
			direccion.getIddireccion(),
			direccion.getCiudad(),
			direccion.getCalle(),
			direccion.getNumero(),
			direccion.getLatitud(),
			direccion.getLongitud()
			);
	}
	
	public Direccion modelToEntity(DireccionModel direccionModel) {
		return new Direccion (
			direccionModel.getIddireccion(),
			direccionModel.getCiudad(),
			direccionModel.getCalle(),
			direccionModel.getNumero(),
			direccionModel.getLatitud(),
			direccionModel.getLongitud()
			);
	}

}
