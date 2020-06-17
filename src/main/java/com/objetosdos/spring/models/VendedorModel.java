package com.objetosdos.spring.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.entities.Sucursal;

public class VendedorModel extends EmpleadoModel{
	
	private float plus;
	private Sucursal sucursal;
	
	//private Set<Pedido> lstPedido= new HashSet<Pedido>(); 
	
	public VendedorModel() {
		super ();
	}
	
	public VendedorModel(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico,Sucursal sucursal/* Pedido pedido*/) {
		super(idPersona,nombre, apellido,fechaNacimiento,dni,horasPorJornada,sueldoBasico);
		this.sucursal = sucursal;
		//this.pedido=pedido;
	}

/*
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	*/

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
