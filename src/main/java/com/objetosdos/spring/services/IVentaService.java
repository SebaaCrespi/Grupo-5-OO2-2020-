package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Venta;
import com.objetosdos.spring.models.VentaModel;

public interface IVentaService {

	public List<Venta> getAll();
	
	public VentaModel findById(int id);
	
	public VentaModel insertOrUptade(VentaModel ventaModel);

}
