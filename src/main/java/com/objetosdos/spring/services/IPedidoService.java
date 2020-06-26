package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.PedidoModel;

public interface IPedidoService {
	
	public List<Pedido> getAll();
	    
	public boolean insertOrUpdate(PedidoModel pedidoModel);
	    
	public boolean stockDisponible(PedidoModel pedidoModel);

	public PedidoModel findById(int id);
	
	public boolean delete(int id);

	public List<Pedido> getPedidoSucursal(int id);
}
