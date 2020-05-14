package com.objetosdos.spring.entities;


import javax.persistence.Entity;


@Entity
public class Cliente extends Persona{
	
	private String mail;
	
	
	public Cliente() {
		super();
	}
/*
	public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, long dni, String mail) {
		super();
		this.mail = mail;
	}
	*/
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
}
