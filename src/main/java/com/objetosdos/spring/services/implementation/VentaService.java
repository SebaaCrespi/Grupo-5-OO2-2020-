package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.VentaConverter;
import com.objetosdos.spring.entities.Venta;
import com.objetosdos.spring.models.VentaModel;
import com.objetosdos.spring.repositories.IVentaRepository;
import com.objetosdos.spring.services.IVentaService;

@Service
public class VentaService implements IVentaService {

	@Autowired
	private IVentaRepository ventaRepository;
	
	@Autowired
	private VentaConverter ventaConverter;

	@Override
	public List<Venta> getAll() {
		// TODO Auto-generated method stub
		return (List<Venta>)ventaRepository.findAll();
	}

	@Override
	public VentaModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VentaModel insertOrUptade(VentaModel ventaModel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
