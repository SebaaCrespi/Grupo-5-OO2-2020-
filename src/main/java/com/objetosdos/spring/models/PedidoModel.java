package com.objetosdos.spring.models;

public class PedidoModel {

	private int idPedido;
	private LoteModel lote;
	private int cantidad;
	private boolean aceptado;
	private VendedorModel vendedorAuxiliar;
	private VentaModel venta;
	
	public PedidoModel() {
		
	}
	
	public PedidoModel(int idPedido, LoteModel lote, int cantidad, VendedorModel vendedorAuxiliar, boolean aceptado) {
		super();
		this.lote = lote;
		this.vendedorAuxiliar=vendedorAuxiliar;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public LoteModel getLote() {
		return lote;
	}

	public void setLote(LoteModel lote) {
		this.lote = lote;
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

	public VendedorModel getVendedorAuxiliar() {
		return vendedorAuxiliar;
	}

	public void setVendedorAuxiliar(VendedorModel vendedorAuxiliar) {
		this.vendedorAuxiliar = vendedorAuxiliar;
	}

	public VentaModel getVenta() {
		return venta;
	}

	public void setVenta(VentaModel venta) {
		this.venta = venta;
	}

	
	
}
