package com.objetosdos.spring.models;

import java.time.LocalDate;

import com.objetosdos.spring.entities.Persona;

public class ClienteModel  extends PersonaModel{ // persona o personamodel?
	
	private String mail;

	public ClienteModel() {
		super();
	}

	public ClienteModel(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, String mail) {
		super(idPersona,nombre,apellido, fechaNacimiento, dni);
		this.mail=mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	
	
	

}
