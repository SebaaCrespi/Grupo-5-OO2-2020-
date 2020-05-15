package com.objetosdos.spring.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Vendedor;

@Repository
public interface IVendedorRepository extends JpaRepository <Vendedor, Serializable> {
	
	public abstract Vendedor findByIdPersona(int id);

}
