package com.objetosdos.spring.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.objetosdos.spring.entities.Venta;
import com.objetosdos.spring.models.VentaModel;

@Component
public class VentaConverter {

	@Autowired private VendedorConverter vendedorConverter;

	@Autowired private ClienteConverter clienteConverter;

	public VentaModel entityToModel(Venta venta) {
		return new VentaModel(
				venta.getNumero(), 
				vendedorConverter.entityToModel(venta.getVendedorEncargado()),
				clienteConverter.entityToModel(venta.getCliente()),
				venta.getFecha(), 
				venta.getHora()
				);
	}
	
	public Venta modelToEntity(VentaModel ventaModel) {
		return new Venta(
				ventaModel.getNumero(),
				vendedorConverter.modelToEntity(ventaModel.getVendedorEncargado()),
				clienteConverter.ModelToEntity(ventaModel.getCliente()),
				ventaModel.getFecha(),
				ventaModel.getHora()
				);
	}
	
	
	/*
	 */
}
