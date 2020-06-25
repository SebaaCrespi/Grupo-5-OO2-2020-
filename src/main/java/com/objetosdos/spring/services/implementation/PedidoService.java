package com.objetosdos.spring.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.LoteConverter;
import com.objetosdos.spring.converters.PedidoConverter;
import com.objetosdos.spring.converters.ProductoConverter;
import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.entities.Vendedor;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.PedidoModel;
import com.objetosdos.spring.repositories.ILoteRepository;
import com.objetosdos.spring.repositories.IPedidoRepository;
import com.objetosdos.spring.repositories.IVendedorRepository;
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
	
	@Override
	public List<Pedido> getAll() {
		
		return pedidoRepository.findAll() ;
	}

	@Override
	public boolean insertOrUpdate(PedidoModel pedidoModel) {
		boolean retorno = false;
		Pedido p = null;
		System.out.println("Antes de entrar al if: "+pedidoModel);
		if(stockDisponible(pedidoModel)) {
			System.out.println("Entré al if "+p);	
			p = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
			System.out.println("1"+p);		
		}
		if(p != null){
			retorno = true;
		}
		return retorno;
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
		for (Lote lote : loteServices.getAll()) {	
			if (pedidoModel.getLote().getIdLote()==lote.getIdLote()) {
				if (pedidoModel.getCantidad() <= lote.getCantidadActual()) {
					cant = lote.getCantidadActual()-pedidoModel.getCantidad();
					lote.setCantidadActual(cant);
					loteRepository.save(lote);
					stock= true;
				}
			}
		}
		System.out.println("Stock: "+stock);
		return stock;
	}
}

