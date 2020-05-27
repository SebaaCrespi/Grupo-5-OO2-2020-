package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.models.ProductoModel;

public interface IProductoService {
	
	
	public List<Producto> getAll();
	
	public ProductoModel findByIdProducto(int id);
	
	public ProductoModel insertOrUpdate(ProductoModel productoModel);
	
	public boolean delete (int id);
	

}
