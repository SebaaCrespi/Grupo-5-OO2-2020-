package com.objetosdos.spring.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vendedor extends Empleado{
	
	
	private float plus;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idsucursal", nullable=false) // En la tala vendedor se relaciona con idsucursal la sucursal
	private Sucursal sucursal;


	public Vendedor(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico, Sucursal sucursal) {
		super(idPersona,nombre,  apellido, fechaNacimiento, dni, horasPorJornada, sueldoBasico);
		this.plus = plus;
		this.sucursal = sucursal;
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
