package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.LoteConverter;
import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.repositories.ILoteRepository;
import com.objetosdos.spring.services.ILoteService;


@Service
public class LoteService implements ILoteService{
	
	
	@Autowired
	private ILoteRepository loteRepository;
	
	@Autowired
	private LoteConverter loteConverter;

	@Override
	public List<Lote> getAll() {
		
		return loteRepository.findAll();
	}

	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) {
		Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
        return loteConverter.entityToModel(lote);
	}

	@Override
	public LoteModel findById(int id) {
		return loteConverter.entityToModel(loteRepository.findByIdLote(id));
	}

	@Override
	public boolean delete(int id) {
		try {
			loteRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	

}
