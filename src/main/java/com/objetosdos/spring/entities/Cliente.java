package com.objetosdos.spring.entities;

import java.time.LocalDate;

import javax.persistence.Entity;


@Entity
public class Cliente extends Persona{
	
	private String mail;
	
	
	public Cliente() {
		super();
	}

	public Cliente(int idPersona,String nombre, String apellido, LocalDate fechaNacimiento, long dni, String mail) {
		super(idPersona,nombre,apellido,fechaNacimiento,dni);
		this.mail = mail;
	}
	
	

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
	

	
	
	
	
	

}
