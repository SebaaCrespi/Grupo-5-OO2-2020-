package com.objetosdos.spring.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.entities.Producto;
import com.objetosdos.spring.entities.Sucursal;

public class LoteModel {
	
	
	private int idLote;
	private Producto producto;
	private String talle;
	private int cantidadActual;
	private int cantidadInicial;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaIngreso;
	private Sucursal sucursal;
	private List<Pedido> pedido;
	
	public LoteModel() {
		
	}
	public LoteModel(int idLote,Producto producto, String talle, int cantidadActual, int cantidadInicial, LocalDate fechaIngreso,
			Sucursal sucursal, List<Pedido> pedido) {
		super();
		this.idLote=idLote;
		this.producto = producto;
		this.talle = talle;
		this.cantidadActual = cantidadActual;
		this.cantidadInicial = cantidadInicial;
		this.fechaIngreso = fechaIngreso;
		this.sucursal = sucursal;
		this.pedido=pedido;
	}
	@Override
	public String toString() {
		return ""+idLote+" | "+producto+" | "+talle+" | ";
	}
	
	
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public int getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public int getCantidadInicial() {
		return cantidadInicial;
	}
	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	
	

}
