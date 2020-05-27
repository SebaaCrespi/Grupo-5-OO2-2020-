package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.models.SucursalModel;


public interface ISucursalService {

	public List<Sucursal> getAll();
    
    public SucursalModel insertOrUpdate(SucursalModel sucursalModel);

    public SucursalModel findById(int id);
    
    public void delete(int id);
    
    public double calcularDistancia(double latitud1,double long1,double lat2, double long2);
    
}
