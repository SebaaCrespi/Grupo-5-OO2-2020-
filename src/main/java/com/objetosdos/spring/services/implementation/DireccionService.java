package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.DireccionConverter;
import com.objetosdos.spring.entities.Direccion;
import com.objetosdos.spring.models.DireccionModel;
import com.objetosdos.spring.repositories.IDireccionRepository;
import com.objetosdos.spring.services.IDireccionService;

@Service
public class DireccionService implements IDireccionService {
	
    @Autowired
    private IDireccionRepository direccionRepository;	

    @Autowired
    private DireccionConverter direccionConverter;
        
    @Override
    public DireccionModel insertOrUpdate(DireccionModel sucursalModel) {       
        Direccion direccion = direccionRepository.save(direccionConverter.modelToEntity(sucursalModel));
        return direccionConverter.entityToModel(direccion);
        
        
    }

	@Override
	public List<Direccion> getAll() {
		
		return direccionRepository.findAll();
		
	}

	@Override
	public DireccionModel findById(int id) {
		System.out.println("EL ID DE DIRECCION CUANDI BUSCA ES"+id);
		return direccionConverter.entityToModel(direccionRepository.findById(id));
	}
}
