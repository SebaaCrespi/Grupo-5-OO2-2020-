package com.objetosdos.spring.models;



import com.objetosdos.spring.entities.Direccion;
import com.objetosdos.spring.entities.Gerente;


public class SucursalModel {
	
	
	private int id;
	private Direccion ubicacion;
	private long telefono;
	private Gerente gerente;
	
	public SucursalModel() {
		
	}
	
	public SucursalModel(int id, Direccion ubicacion, long telefono, Gerente gerente) {
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
	public Direccion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Direccion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
	



}
