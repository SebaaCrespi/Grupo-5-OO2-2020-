package com.objetosdos.spring.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.SucursalConverter;
import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Sucursal;

import com.objetosdos.spring.models.SucursalModel;
import com.objetosdos.spring.repositories.ISucursalRepository;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.ISucursalService;


@Service
public class SucursalService implements ISucursalService{
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	@Autowired
	private SucursalConverter sucursalConverter;
	@Autowired
	private ILoteService loteServices;
	
	@Override
	public List<Sucursal> getAll() {
		//Casteo de tipo Sucursal
		return (List<Sucursal>)sucursalRepository.findAll();
	}

	@Override
	public SucursalModel findById(int id) {	
		return sucursalConverter.entityToModel(sucursalRepository.findById(id));
	}

	@Override
	public SucursalModel insertOrUpdate(SucursalModel sucursalModel) {
		Sucursal sucursal = sucursalRepository.save(sucursalConverter.modelToEntity(sucursalModel));
		return sucursalConverter.entityToModel(sucursal);
	}

	@Override
	public void delete(int id) {
		sucursalRepository.deleteById(id);
	}
	@Override
	public List<Lote> getLotes(int idSucursalActual){
		List<Lote> lstLotes = new ArrayList<Lote>();
        for(Lote lote : loteServices.getAll()){
            if(lote.getSucursal().getId() == idSucursalActual){
                lstLotes.add(lote);
            }
		}
		return lstLotes;
	}
	@Override
	public double calcularDistancia(double lat1,double long1,double lat2, double long2) {
		double radioTierra =6371; //kilometros.
		double dLat = Math.toRadians(lat2-lat1);
		double dLong=Math.toRadians(long2-long1);
		double sindLat = Math.sin(dLat/2);
		double sindLong = Math.sin(dLong/2);
		double va1 = Math.pow(sindLat, 2) + Math.pow(sindLong, 2)* Math.cos(Math.toRadians(lat1))*Math.cos(Math.toRadians(lat2));
		double va2=2*Math.atan2(Math.sqrt(va1), Math.sqrt(1-va1));

		return radioTierra * va2;
		}
}
