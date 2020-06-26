package com.objetosdos.spring.services.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.SucursalConverter;
import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.SucursalModel;
import com.objetosdos.spring.repositories.ISucursalRepository;
import com.objetosdos.spring.services.ISucursalService;

@Service
public class SucursalService implements ISucursalService{
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	@Autowired
	private SucursalConverter sucursalConverter;
	
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
	public List<String> getVariedadTalle(List<Lote> lstLotes){
		List<String> lstVariedad = new ArrayList<String>();
		for(Lote lote : lstLotes){
			for(String variedad : lstVariedad){
				if(variedad != lote.getTalle()){
					lstVariedad.add(lote.getTalle());
				}
			}
		}
		return lstVariedad;
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

	@Override
	public List<Double> traerListaDeDistancias(List<SucursalModel> sucursalOrdenada, SucursalModel sucursalActual){
		List<Double> distancias = new ArrayList<Double>();
		for(SucursalModel s : sucursalOrdenada){
			distancias.add(calcularDistancia(
				sucursalActual.getUbicacion().getLatitud(),
				sucursalActual.getUbicacion().getLongitud(),
				s.getUbicacion().getLatitud(),
				s.getUbicacion().getLongitud()
				));
		}
		return distancias;
	}	

	@Override
	public List<SucursalModel> traerSucursalesMasCercanas(List<LoteModel> lstLotes, SucursalModel sucursalActual){
		List<Double> distancias = new ArrayList<Double>();
		List<SucursalModel> sucursales = new ArrayList<SucursalModel>();
		List<SucursalModel> sucursalesOrdenadas = new ArrayList<SucursalModel>();
		for(LoteModel l : lstLotes){
			sucursales.add(sucursalConverter.entityToModel(l.getSucursal()));
			distancias.add(calcularDistancia(
				sucursalActual.getUbicacion().getLatitud(),
				sucursalActual.getUbicacion().getLongitud(),
				l.getSucursal().getUbicacion().getLatitud(),
				l.getSucursal().getUbicacion().getLongitud()
				));
		}
		Collections.sort(distancias);
		for(int i = 0 ; i < 3 ; i++){
			if(i < 3 && distancias.size() > i){
				for(SucursalModel s : sucursales){
					Double distanciaActual = calcularDistancia(
						sucursalActual.getUbicacion().getLatitud(),
						sucursalActual.getUbicacion().getLongitud(),
						s.getUbicacion().getLatitud(),
						s.getUbicacion().getLongitud());	
					if(distancias.get(i).equals(distanciaActual)){
						sucursalesOrdenadas.add(s);
					}
				}
			}
		}
		System.out.println(distancias);
		System.out.println(sucursalesOrdenadas);
		return sucursalesOrdenadas;
	}	
	/*public List<LoteModel> traerLotesMasCercanos(List<LoteModel> lstLotes, SucursalModel sucursalActual){
		List<LoteModel> lotesCercanos = new ArrayList<LoteModel>();
		List<Double> distancias = new ArrayList<Double>();
		for(LoteModel l : lstLotes){
			distancias.add(calcularDistancia(
				sucursalActual.getUbicacion().getLatitud(),
				sucursalActual.getUbicacion().getLongitud(),
				l.getSucursal().getUbicacion().getLatitud(),
				l.getSucursal().getUbicacion().getLongitud()
				));
		}
		Collections.sort(distancias);
		for(int i = 0 ; i < 3 ; i++){
			if(i < 3 && distancias.size() > i){
				for(LoteModel l : lstLotes){
					Double distanciaActual = calcularDistancia(
						sucursalActual.getUbicacion().getLatitud(),
						sucursalActual.getUbicacion().getLongitud(),
						l.getSucursal().getUbicacion().getLatitud(),
						l.getSucursal().getUbicacion().getLongitud());	
					if(distancias.get(i).equals(distanciaActual)){
						lotesCercanos.add(l);
					}
				}
			}
		}
		return lotesCercanos;
	}*/
}
