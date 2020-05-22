package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Direccion;
import com.objetosdos.spring.models.DireccionModel;

public interface IDireccionService {
	
	public   List<Direccion> getAll();
	
	public DireccionModel findById(int id);

    public DireccionModel insertOrUpdate(DireccionModel sucursalModel);
}
