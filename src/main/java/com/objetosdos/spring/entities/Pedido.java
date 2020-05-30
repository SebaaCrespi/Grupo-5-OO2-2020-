package com.objetosdos.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Producto producto;
	
	private int cantidad;
	private boolean aceptado;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Vendedor vendedorAuxiliar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idventa", nullable=true) // En la tabla venta se relaciona con idventa la venta
	private Venta venta;
	
	public Pedido() {
		
	}
	
	public Pedido(Producto producto, int cantidad, Vendedor vendedorAuxiliar, boolean aceptado) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
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

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	@Override
	public String toString() {
		return "\n  Pedido [producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}