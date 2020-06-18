package com.objetosdos.spring.models;


public class SucursalModel {
	
	
	private int id;
	private DireccionModel ubicacion;
	private long telefono;
	private GerenteModel gerente;
	//private Set<VendedorModel> lstVendedor;
	public SucursalModel() {
		
	}
	
	public SucursalModel(int id, DireccionModel ubicacion, long telefono, GerenteModel gerente) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.gerente = gerente;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DireccionModel getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(DireccionModel ubicacion) {
		this.ubicacion = ubicacion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public GerenteModel getGerente() {
		return gerente;
	}
	public void setGerente(GerenteModel gerente) {
		this.gerente = gerente;
	}
	
	/*
	public Set<VendedorModel> getLstVendedor() {
		return lstVendedor;
	}
	public void setLstVendedor(Set<VendedorModel> lstVendedor) {
		this.lstVendedor = lstVendedor;
	}
	
	*/



}
