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

		return pedidoRepository.findAll();
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
