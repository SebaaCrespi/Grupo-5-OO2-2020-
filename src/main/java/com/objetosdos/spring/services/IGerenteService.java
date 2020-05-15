package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Gerente;
import com.objetosdos.spring.models.GerenteModel;

public interface IGerenteService {
    
    public List<Gerente> getAll();
    
    public GerenteModel insertOrUpdate(GerenteModel gerenteModel);

    public GerenteModel findById(int id);

    public void delete(int id);
}