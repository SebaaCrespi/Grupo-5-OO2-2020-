package com.objetosdos.spring.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Vendedor extends Empleado{
	
	
	private float plus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idsucursal", nullable=true) // En la tabla vendedor se relaciona con idsucursal la sucursal
	private Sucursal sucursal;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy = "vendedorAuxiliar") 
	private Pedido pedido;

public Vendedor(){
	
}
	public Vendedor(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico,Sucursal sucursal,Pedido pedido) {
		super(idPersona,nombre,  apellido, fechaNacimiento, dni, horasPorJornada, sueldoBasico);
		this.sucursal=sucursal;
		this.pedido=pedido;
	}


	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
