package com.objetosdos.spring.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLote")
	private Lote lote;
	
	private int cantidad;
	private boolean aceptado;
	private boolean vendido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idvendedor", nullable=true)
	private Vendedor vendedorAuxiliar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idSucursal", nullable=true)
	private Sucursal sucursal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idVenta", nullable=true)
	private Venta venta;
	
	public Pedido() {
		
	}
	
	public Pedido(int idPedido,Lote lote, int cantidad, Vendedor vendedorAuxiliar, boolean aceptado, Sucursal sucursal, boolean vendido) {
		this.idPedido = idPedido;
		this.lote = lote;
		this.cantidad = cantidad;
		this.aceptado = aceptado;
		this.vendedorAuxiliar=vendedorAuxiliar;
		this.sucursal = sucursal;
	}
	
	public Lote getLote() {
		return lote;
	}
	
	public void setLote(Lote lote) {
		this.lote = lote;
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
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	@Override
	public String toString() {
		return "\n  Pedido [producto=" + lote + ", cantidad=" + cantidad + "]";
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	

}
