package com.objetosdos.spring.models;

import java.time.LocalDate;

import com.objetosdos.spring.entities.Sucursal;

public class VendedorModel extends EmpleadoModel{
	
	private float plus;
	private Sucursal sucursal;
	
	public VendedorModel() {super ();
	}
	
	public VendedorModel(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico,Sucursal sucursal) {
		super(idPersona,nombre, apellido,fechaNacimiento,dni,horasPorJornada,sueldoBasico);
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
