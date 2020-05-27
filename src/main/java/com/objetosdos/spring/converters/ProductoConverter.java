package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.models.ProductoModel;


@Component
public class ProductoConverter {
	
	
	public Producto modelToEntity(ProductoModel productoModel) {
		
		return new Producto
						(productoModel.getId(),
						productoModel.isStatus(),
						productoModel.getDescripcion(),
						productoModel.getPrecioUnitario(),
						productoModel.getFechaAlta(),
						productoModel.getMarca(),
						productoModel.getLstLote()
						);
		
	}
	
public ProductoModel entityToModel(Producto producto) {
		
		return new ProductoModel
								(producto.getId(),
								producto.isStatus(),
								producto.getDescripcion(),
								producto.getPrecioUnitario(),
								producto.getFechaAlta(),
								producto.getMarca(),
								producto.getLstLote()
						);
		
	}

}
