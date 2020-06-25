package com.objetosdos.spring.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.PedidoModel;

@Component
public class PedidoConverter {

	@Autowired
	private LoteConverter loteConverter;
	@Autowired
	private VendedorConverter vendedorConverter;

public Pedido modelToEntity(PedidoModel pedidoModel) {
		
		return new Pedido
						(pedidoModel.getIdPedido()		,
						loteConverter.modelToEntity(pedidoModel.getLote()),
						pedidoModel.getCantidad(),
						vendedorConverter.modelToEntity(pedidoModel.getVendedorAuxiliar()),
						pedidoModel.isAceptado()/*,
						ventaConverter.modelToEntity(pedidoModel.getVenta())	*/
						);
		
	}
	
public PedidoModel entityToModel(Pedido pedido) {

		return new PedidoModel(		
			pedido.getIdPedido(),
			loteConverter.entityToModel(pedido.getLote()),
			pedido.getCantidad(),
			vendedorConverter.entityToModel(pedido.getVendedorAuxiliar()),
			pedido.isAceptado()/*,
			ventaConverter.entityToModel(pedido.getVenta())*/
		);
	}

	
}
