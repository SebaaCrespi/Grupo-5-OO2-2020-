package com.objetosdos.spring.entities;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class SolcitudPedido {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "idLote")
	private Pedido pedido;
	
	private int cantidad;
	private boolean aceptado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idvendedor", nullable=true)
	private Vendedor vendedor;

    
	
}