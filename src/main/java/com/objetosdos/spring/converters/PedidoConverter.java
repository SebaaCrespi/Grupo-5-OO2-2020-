package com.objetosdos.spring.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PedidoConverter {

	@Autowired
	private VendedorConverter vendedorConverter;
	
/*	public PedidoModel entityToModel(Pedido pedido) {
		return new PedidoModel();
	}*/
	
	/*
	 * public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(
				producto.getId(),
				producto.isStatus(),
				producto.getDescripcion(),
				producto.getPrecioUnitario(),
				producto.getFechaAlta(),
				producto.getMarca()
				);
	}*/
	
}
