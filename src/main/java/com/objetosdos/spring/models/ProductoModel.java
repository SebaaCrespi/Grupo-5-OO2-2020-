package com.objetosdos.spring.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.objetosdos.spring.entities.Lote;

public class ProductoModel {

	private int id;
	private boolean status;
	private String descripcion;
	private float precioUnitario;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAlta;
	private String marca;
	private Set<Lote> lstLote= new HashSet<Lote>();
	
	public ProductoModel() {
		
	}
	
	
	public ProductoModel(int id,boolean status, String descripcion, float precioUnitario, LocalDate fechaAlta,
			String marca, Set<Lote> lstLote) {
		super();
		this.id = id;
		this.status = status;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.fechaAlta = fechaAlta;
		this.marca = marca;
		this.lstLote = lstLote;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Set<Lote> getLstLote() {
		return lstLote;
	}
	public void setLstLote(Set<Lote> lstLote) {
		this.lstLote = lstLote;
	} 
	
	
	
	
	
	
}
