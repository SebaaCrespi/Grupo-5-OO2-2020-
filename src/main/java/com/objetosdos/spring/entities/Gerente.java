package com.objetosdos.spring.entities;


import java.time.LocalDate;

import javax.persistence.Entity;


@Entity
public class Gerente extends Empleado{
	public Gerente(){
		
	}
	public Gerente(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico) {
		super(idPersona,nombre, apellido, fechaNacimiento, dni, horasPorJornada, sueldoBasico);
	}
	
}
