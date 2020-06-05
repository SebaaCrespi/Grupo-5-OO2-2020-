package com.objetosdos.spring.converters;

import org.springframework.stereotype.Component;

import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.PedidoModel;

@Component
public class PedidoConverter {
	
public Pedido modelToEntity(PedidoModel pedidoModel) {
		
		return new Pedido
						(pedidoModel.getIdPedido()		,
						pedidoModel.getProducto(),
						pedidoModel.getCantidad(),
						pedidoModel.getVendedorAuxiliar(),
						pedidoModel.isAceptado(),
						pedidoModel.getVenta()
								
						);
		
	}
	
public PedidoModel entityToModel(Pedido pedido) {
		
		return new PedidoModel
								(		pedido.getIdPedido(),
										pedido.getProducto(),
										pedido.getCantidad(),
										pedido.getVendedorAuxiliar(),
										pedido.isAceptado(),
										pedido.getVenta()
											
								
						);
		
	}

	
}
