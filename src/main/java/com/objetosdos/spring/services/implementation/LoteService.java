package com.objetosdos.spring.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.LoteConverter;
import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.ProductoModel;
import com.objetosdos.spring.models.SucursalModel;
import com.objetosdos.spring.repositories.ILoteRepository;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.ISucursalService;


@Service
public class LoteService implements ILoteService{
	
	
	@Autowired
	private ILoteRepository loteRepository;
	
	@Autowired
	private LoteConverter loteConverter;

	@Autowired
	private ISucursalService sucursalServices;
	@Autowired
	private ProductoService productoservices;

	@Override
	public List<Lote> getAll() {
		
		return loteRepository.findAll();
	}

	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) {
	
	Lote lote = loteRepository.save(loteConverter.modelToEntity(loteModel));
	LoteModel l =loteConverter.entityToModel(lote);
	
	ProductoModel p = productoservices.findByIdProducto(l.getProducto().getId()); //traigo el id producto que corresponde a ese loteModel
	if (l.getCantidadActual()>0)
	{
		p.setStatus(true);
		productoservices.insertOrUpdate(p); //guardo ese productoModel
	}
	return l;
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
	@Override
	public List<LoteModel> getLotes(int idSucursalActual){
		List<LoteModel> lstLotes = new ArrayList<LoteModel>();
        for(Lote lote : getAll()){
            if(lote.getSucursal().getId() == idSucursalActual){
                lstLotes.add(loteConverter.entityToModel(lote));
            }
		}
		return lstLotes;
	}
	@Override
	public List<String> getAllMarca(){
		return loteRepository.getAllMarca();
	}

	@Override
    public  List<String> getAllTalle(String marca,String descripcion){
        return loteRepository.getAllTalle(marca, descripcion);
	}
	
	@Override
    public List<String> getAllDescripcion(String marca){
        return loteRepository.getAllDescripcion(marca);
	}

	@Override
    public List<LoteModel> getBusquedaProducto(String marca, String descripcion, String talle) {
		List<LoteModel> lstLoteModel = new ArrayList<LoteModel>();
		for(Lote lote : loteRepository.getBusquedaProducto(marca, descripcion, talle)){
			lstLoteModel.add(loteConverter.entityToModel(lote));
		}
        return lstLoteModel;
	}
	
	@Override
	public LoteModel getBusquedaProductoEnSucursal(int idSucursalActual,String marca, String descripcion, String talle){
		LoteModel loteEncontrado = null;
		for(LoteModel lote : getLotes(idSucursalActual)){
			if(lote.getProducto().getMarca().equals(marca)){
				if(lote.getProducto().getDescripcion().equals(descripcion)){
					if(lote.getTalle().equals(talle)){
						loteEncontrado = lote;
					}
				}
			}
		}
		return loteEncontrado;
	}
	
	
	
	@Override
	public List<ProductoModel> getAllProductoSuc(int id){
		//SucursalModel suc = sucursalServices.findById(id);
		
		List<ProductoModel> pro = new ArrayList<ProductoModel>();
		for(Lote lote : getAll()){
            if(lote.getSucursal().getId() == id){
            	pro.add(productoservices.findByIdProducto(lote.getProducto().getId()));
            }
              
            }
		return pro;
		
		
	}
}
