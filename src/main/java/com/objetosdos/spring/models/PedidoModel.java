package com.objetosdos.spring.models;

import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.entities.Vendedor;

public class PedidoModel {
	
	private Producto producto;
	private int cantidad;
	private Vendedor vendedorAuxiliar;
	
	public PedidoModel() {}
	
	public PedidoModel(Producto producto, int cantidad, Vendedor vendedorAuxiliar) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}
	
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Vendedor getVendedorAuxiliar() {
		return vendedorAuxiliar;
	}
	public void setVendedorAuxiliar(Vendedor vendedorAuxiliar) {
		this.vendedorAuxiliar = vendedorAuxiliar;
	}

	@Override
	public String toString() {
		return "\n  Pedido [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
}
