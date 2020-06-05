package com.objetosdos.spring.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objetosdos.spring.converters.PedidoConverter;
import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.PedidoModel;
import com.objetosdos.spring.repositories.IPedidoRepository;
import com.objetosdos.spring.services.IPedidoService;



@Service
public class PedidoService implements IPedidoService {

	
	@Autowired
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoConverter pedidoConverter;
	
	@Override
	public List<Pedido> getAll() {
		
		return pedidoRepository.findAll() ;
	}

	@Override
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) {
		Pedido p = pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel));
		PedidoModel pedido =pedidoConverter.entityToModel(p);
		return pedido;
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
}
