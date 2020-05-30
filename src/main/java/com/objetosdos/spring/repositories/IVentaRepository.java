package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

	public abstract Venta findByNumero(int id);
	
}
