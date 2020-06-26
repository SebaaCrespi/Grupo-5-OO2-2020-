package com.objetosdos.spring.models;

public class PedidoModel {

	private int idPedido;
	private LoteModel lote;
	private int cantidad;
	private boolean aceptado;
	private VendedorModel vendedorAuxiliar;
	private boolean vendido;
	private SucursalModel sucursal;
	
	public PedidoModel() {
		
	}
	
	public PedidoModel(int idPedido, LoteModel lote, int cantidad, VendedorModel vendedorAuxiliar, boolean aceptado, SucursalModel sucursal, boolean vendido){
		this.lote = lote;
		this.vendedorAuxiliar=vendedorAuxiliar;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.sucursal = sucursal;
		this.vendido = vendido;
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

	public SucursalModel getSucursal() {
		return sucursal;
	}

	public void setSucursal(SucursalModel sucursal) {
		this.sucursal = sucursal;
	}

	@Override
	public String toString() {
		return "PedidoModel [aceptado=" + aceptado + ", cantidad=" + cantidad + ", idPedido=" + idPedido + ", lote="
				+ lote + ", vendedorAuxiliar=" + vendedorAuxiliar + ", vendido=" + vendido + "]";
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

}
