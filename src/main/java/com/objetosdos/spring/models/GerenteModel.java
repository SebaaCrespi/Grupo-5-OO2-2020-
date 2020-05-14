package com.objetosdos.spring.models;

import java.time.LocalDate;

public class GerenteModel extends EmpleadoModel{
    public GerenteModel() {
		
	}
	public GerenteModel(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni,int horasPorJornada, float sueldoBasico) {
		super(idPersona,nombre,apellido, fechaNacimiento,dni,horasPorJornada,sueldoBasico);

	}
}