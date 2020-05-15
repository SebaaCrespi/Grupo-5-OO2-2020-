package com.objetosdos.spring.services.implementation;
import java.util.List;

import com.objetosdos.spring.converters.GerenteConverter;
import com.objetosdos.spring.entities.Gerente;
import com.objetosdos.spring.models.GerenteModel;
import com.objetosdos.spring.repositories.IGerenteRepository;
import com.objetosdos.spring.services.IGerenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GerenteService implements IGerenteService{

    @Autowired
	private IGerenteRepository gerenteRepository;
    @Autowired
    private GerenteConverter gerenteConverter;

    @Override
    public List<Gerente> getAll(){     /* PORQUE ACA ES CON LA ENTIDAD?*/
		return gerenteRepository.findAll();
    }
    @Override
    public GerenteModel findById(int id){
        return gerenteConverter.entityToModel(gerenteRepository.findById(id));

    }    
    @Override
    public GerenteModel insertOrUpdate(GerenteModel gerenteModel){
        Gerente gerente = gerenteRepository.save(gerenteConverter.modelToEntity(gerenteModel));
        return gerenteConverter.entityToModel(gerente);
    }
    @Override
    public void delete(int id){
        gerenteRepository.deleteById(id);
    }
    
}