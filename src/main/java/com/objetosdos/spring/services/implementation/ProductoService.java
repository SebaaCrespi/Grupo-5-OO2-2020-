package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.ProductoConverter;
import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.models.ProductoModel;
import com.objetosdos.spring.repositories.IProductoRepository;
import com.objetosdos.spring.services.IProductoService;


@Service
public class ProductoService implements IProductoService{
	
	
	@Autowired
	private IProductoRepository repositoryProducto;
	
	@Autowired
	private ProductoConverter productoConverter;
	
	
	

	@Override
	public List<Producto> getAll() {
		
		return repositoryProducto.findAll();
	}

	@Override
	public ProductoModel findByIdProducto(int id) {
		
	return productoConverter.entityToModel(repositoryProducto.findById(id));
	}

	@Override
	public ProductoModel insertOrUpdate(ProductoModel productoModel) {
		Producto producto = repositoryProducto.save(productoConverter.modelToEntity(productoModel)); // de repo se guarda el
		// cliente convertido en
		// persona
return productoConverter.entityToModel(producto); // se convierte en modelo la persona.
		
	}

	@Override
	public boolean delete(int id) {
		try {
			repositoryProducto.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		
	}
		
	}
}

	
	
	

