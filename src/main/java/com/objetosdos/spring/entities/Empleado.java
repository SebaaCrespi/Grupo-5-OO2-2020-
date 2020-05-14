package com.objetosdos.spring.entities;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class Empleado extends Persona{

	protected int horasPorJornada;
	protected float sueldoBasico;
	public Empleado(){

	}
	public Empleado(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, 
					int horasPorJornada, float sueldoBasico) {
		super(idPersona,nombre,apellido,fechaNacimiento,dni);
		this.horasPorJornada = horasPorJornada;
		this.sueldoBasico = sueldoBasico;
	}
	public int getHorasPorJornada() {
		return horasPorJornada;
	}
	public void setHorasPorJornada(int horasPorJornada) {
		this.horasPorJornada = horasPorJornada;
	}
	public float getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
}
