package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.LoteConverter;
import com.objetosdos.spring.converters.PedidoConverter;
import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.PedidoModel;
import com.objetosdos.spring.repositories.ILoteRepository;
import com.objetosdos.spring.repositories.IPedidoRepository;
import com.objetosdos.spring.services.ILoteService;
import com.objetosdos.spring.services.IPedidoService;



@Service
public class PedidoService implements IPedidoService {

	
	@Autowired
	private IPedidoRepository pedidoRepository;

	@Autowired
	private ILoteRepository loteRepository;
	
	@Autowired
	private PedidoConverter pedidoConverter;
	
	@Autowired
	private ILoteService loteServices;
	@Autowired
	private LoteConverter loteConverter;
	
	@Override
	public List<Pedido> getAll() {
		
		return pedidoRepository.findAll() ;
	}

	@Override
	public boolean insertOrUpdate(PedidoModel pedidoModel) {
		
		
		
		try {	if (stockDisponible(pedidoModel)==true) {
			Pedido p = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
			PedidoModel pedido =pedidoConverter.entityToModel(p);
					
					}
		return true;
				}
	
			
		catch (Exception e){
			return false;
			
		}
		
		//return pedido;
	}

	@Override
	public PedidoModel findById(int id) {
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(id));
		
	}

	@Override
	public boolean delete(int id) {
		try {
			pedidoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

}
	
	@Override
	public boolean stockDisponible(PedidoModel pedidoModel) {
		
		boolean stock= false;
		int cant =0;
		Lote l=null;
		LoteModel lo=null;

		for (Lote lote : loteServices.getAll()) {
			
			if (pedidoModel.getProducto().getIdLote()==lote.getIdLote()) {
				if (pedidoModel.getCantidad()<=lote.getCantidadActual()) {
					cant = lote.getCantidadActual()-pedidoModel.getCantidad();
					lote.setCantidadActual(cant);
					l= loteRepository.save(lote);
					lo= loteConverter.entityToModel(l);
					stock= true;
				}
	}
			
}
		return stock;
	}
	}
