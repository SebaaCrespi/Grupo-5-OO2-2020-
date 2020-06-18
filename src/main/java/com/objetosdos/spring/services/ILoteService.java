package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.ProductoModel;

public interface ILoteService {
    
    public List<Lote> getAll();
    
    public LoteModel insertOrUpdate(LoteModel loteModel);

    public LoteModel findById(int id);
    
    public boolean delete(int id);
    
    public List<LoteModel> getLotes(int idSucursalActual);
    
    public List<String> getAllMarca();
    
    public List<String> getAllTalle(String marca,String descripcion);
    
    public List<String> getAllDescripcion(String marca);
    
    public List<LoteModel> getBusquedaProducto(String marca, String descripcion, String talle);
    
    public LoteModel getBusquedaProductoEnSucursal(int idSucursalActual, String marca, String descripcion, String talle);
    
    public List<ProductoModel> getAllProductoSuc(int id);
}
