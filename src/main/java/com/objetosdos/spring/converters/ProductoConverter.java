package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.models.ProductoModel;


@Component
public class ProductoConverter {

	//De entidad a modelo
	public ProductoModel entityToModel(Producto productoModel) {
		return new ProductoModel(
				productoModel.getId(),
				productoModel.isStatus(),
				productoModel.getDescripcion(),
				productoModel.getPrecioUnitario(),
				productoModel.getFechaAlta(),
				productoModel.getMarca()
				);
	}
	
	//De modelo a entidad
	public Producto modelToEntity(ProductoModel productoModel) {
		return new Producto(
				productoModel.getId(),
				productoModel.isStatus(),
				productoModel.getDescripcion(),
				productoModel.getPrecioUnitario(),
				productoModel.getFechaAlta(),
				productoModel.getMarca()
				);
		
	}
	

}
