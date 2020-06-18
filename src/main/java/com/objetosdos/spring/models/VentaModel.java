package com.objetosdos.spring.models;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class VentaModel {

	
	private int numero;
	//private List<Pedido>lstPedidos;
	private VendedorModel vendedorEncargado;
	private ClienteModel cliente;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	private LocalTime hora;
	private float precioTotal;
	
	public VentaModel() {
	}
	
	public VentaModel(int numero, VendedorModel vendedorEncargado, ClienteModel cliente, LocalDate fecha,
			LocalTime hora) {
		super();
		this.numero = numero;
		//this.lstPedidos = new ArrayList<Pedido>();
		this.vendedorEncargado = vendedorEncargado;
		this.cliente = cliente;
		this.fecha = fecha;
		this.hora = hora;
		this.precioTotal = 0;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

/*	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}
*/
	
	public VendedorModel getVendedorEncargado() {
		return vendedorEncargado;
	}

	public void setVendedorEncargado(VendedorModel vendedorEncargado) {
		this.vendedorEncargado = vendedorEncargado;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public float precioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	@Override
	public String toString() {
		return "Venta [numero=" + numero + ", \n precio total=" + precioTotal +", \n vendedorEncargado=" + vendedorEncargado
				+ ", \n cliente=" + cliente + ", \n fecha=" + fecha + ", \n hora=" + hora + "]";
	}
	
}
