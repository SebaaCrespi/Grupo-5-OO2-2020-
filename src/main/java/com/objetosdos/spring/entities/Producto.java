package com.objetosdos.spring.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Producto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean status;
	private String descripcion;
	private float precioUnitario;
	private LocalDate fechaAlta;
	private String marca;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
	private Set<Lote> lstLote= new HashSet<Lote>(); 
	
	public Producto() {
		
	}
	
	public Producto(int id, boolean status, String descripcion, float precioUnitario, LocalDate fechaAlta,
			String marca,Set<Lote> lstLote) {
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

	public boolean equals(Producto producto) {
	return producto.getDescripcion().equalsIgnoreCase(descripcion);
	}

	public String toString(){
		return id+"/"+status+"/"+descripcion+"/"+precioUnitario+"/"+fechaAlta+"/"+marca; }
	
	/*--------------------------------------------------*/
	
	/** 
	 *
	 * desactivarProducto
	 * 
	 * Se desactiva el Producto
	 *  El status del Producto cambia a "false"
	 * 
	 */

	public void desactivarProducto() {
		status = false;
	}
	
	/*--------------------------------------------------*/
	
	/** 
	 *
	 *activarProducto
	 * Se activa el Producto
	 *  El status del Producto cambia a "true"
	 * 
	 */
	
	public void activarProducto() {
		status = true;
	}
	
	/*--------------------------------------------------*/

}


