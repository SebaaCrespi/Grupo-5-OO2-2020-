package com.objetosdos.spring.entities;

public class RankingProducto {


	private Producto producto;
	private int cantidad;
	
	public RankingProducto(Producto producto, int cantidad) {
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
	@Override
	public String toString() {
		return "\nRankingProductos [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
}
