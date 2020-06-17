package com.objetosdos.spring.entities;

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
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLote")
	private Lote producto;
	
	private int cantidad;
	private boolean aceptado;

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idvendedor", nullable=true) // En la tabla venta se relaciona con idventa la venta
	private Vendedor vendedorAuxiliar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idventa", nullable=true) // En la tabla venta se relaciona con idventa la venta
	private Venta venta;
	
	public Pedido() {
		
	}
	
	public Pedido(int idPedido,Lote producto, int cantidad, Vendedor vendedorAuxiliar, boolean aceptado, Venta venta) {
		super();
		this.idPedido = idPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.vendedorAuxiliar=vendedorAuxiliar;
		this.venta = venta;
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

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "\n  Pedido [producto=" + producto + ", cantidad=" + cantidad + "]";
	}

}
