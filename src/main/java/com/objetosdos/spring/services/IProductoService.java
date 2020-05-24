package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.models.ProductoModel;

public interface IProductoService {

	public List<Producto> getAll();
    
    public ProductoModel insertOrUpdate(ProductoModel productoModel);

    public ProductoModel findById(int id);
    
    public void delete(int id);
    
}
