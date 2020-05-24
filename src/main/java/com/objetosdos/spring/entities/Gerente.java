package com.objetosdos.spring.entities;


import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class Gerente extends Empleado{
	@OneToOne(mappedBy = "gerente") //si tenes una tabla gerente
	private Sucursal sucursal;
	public Gerente(){
	}
	public Gerente(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, int horasPorJornada,
			float sueldoBasico) {
		super(idPersona,nombre, apellido, fechaNacimiento, dni, horasPorJornada, sueldoBasico);
	}
	
}
