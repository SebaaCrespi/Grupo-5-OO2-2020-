package com.objetosdos.spring.models;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Vendedor;
import com.objetosdos.spring.entities.Venta;

public class PedidoModel {

	private int idPedido;
	private Lote producto;
	private int cantidad;
	private boolean aceptado;
	private Vendedor vendedorAuxiliar;
	private Venta venta;
	
	public PedidoModel() {
		
	}
	
	public PedidoModel(int idPedido, Lote producto, int cantidad, Vendedor vendedorAuxiliar, boolean aceptado,Venta venta) {
		super();
		this.producto = producto;
		this.vendedorAuxiliar=vendedorAuxiliar;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.venta = venta;
		this.venta = venta;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Lote getProducto() {
		return producto;
	}

	public void setProducto(Lote producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Vendedor getVendedorAuxiliar() {
		return vendedorAuxiliar;
	}

	public void setVendedorAuxiliar(Vendedor vendedorAuxiliar) {
		this.vendedorAuxiliar = vendedorAuxiliar;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	
}
