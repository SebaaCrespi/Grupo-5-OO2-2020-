package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.models.LoteModel;

public interface ILoteService {
	
public List<Lote> getAll();
    
    public LoteModel insertOrUpdate(LoteModel loteModel);

    public LoteModel findById(int id);
    
    public boolean delete(int id);
	
	

}
