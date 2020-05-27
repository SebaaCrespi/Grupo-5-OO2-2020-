package com.objetosdos.spring.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Sucursal;

@Repository
public interface ILoteRepository extends JpaRepository<Lote, Serializable>{
	
	public abstract Lote findByIdLote(int id);

}
