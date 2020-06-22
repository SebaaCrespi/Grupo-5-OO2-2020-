package com.objetosdos.spring.entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vendedor extends Empleado{
	
	
	private float plus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idsucursal", nullable=true) // En la tabla vendedor se relaciona con idsucursal la sucursal
	private Sucursal sucursal;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "vendedorAuxiliar") 
	private List<Pedido> lstPedido= new ArrayList<Pedido>(); 

public Vendedor(){
	
}
	public Vendedor(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico,Sucursal sucursal) {
		super(idPersona,nombre,  apellido, fechaNacimiento, dni, horasPorJornada, sueldoBasico);
		this.sucursal=sucursal;
		
	}


	
	public List<Pedido> getLstPedido() {
		return lstPedido;
	}
	public void setLstPedido(List<Pedido> lstPedido) {
		this.lstPedido = lstPedido;
	}
	public float getPlus() {
		return plus;
	}

	public void setPlus(float plus) {
		this.plus = plus;
	}


	public Sucursal getSucursal() {
		return sucursal;
	}


	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	
	
}
