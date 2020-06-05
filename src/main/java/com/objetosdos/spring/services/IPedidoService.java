package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.LoteModel;
import com.objetosdos.spring.models.PedidoModel;

public interface IPedidoService {
	
	  public List<Pedido> getAll();
	    
	    public PedidoModel insertOrUpdate(PedidoModel pedidoModel);

	    public PedidoModel findById(int id);
	    
	    public boolean delete(int id);

}