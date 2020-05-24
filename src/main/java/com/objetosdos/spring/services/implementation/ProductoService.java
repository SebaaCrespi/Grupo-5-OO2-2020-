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
	private IProductoRepository productoRepository;
	
	@Autowired
	private ProductoConverter productoConverter;

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public ProductoModel insertOrUpdate(ProductoModel productoModel) {
		// TODO Auto-generated method stub

		Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
		return productoConverter.entityToModel(producto);
	}

	@Override
	public ProductoModel findById(int id) {
		
		System.out.println("EL ID DE SUCURSAL CUANDI BUSCA ES"+id);
		
		return productoConverter.entityToModel(productoRepository.findById(id));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
