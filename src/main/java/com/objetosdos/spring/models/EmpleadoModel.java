package com.objetosdos.spring.models;

import java.time.LocalDate;

public class EmpleadoModel extends PersonaModel{
	private int horasPorJornada;
	private float sueldoBasico;
	public EmpleadoModel() {
		
	}
	public EmpleadoModel(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni,int horasPorJornada, float sueldoBasico) {
		super(idPersona,nombre,apellido, fechaNacimiento,dni);
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
