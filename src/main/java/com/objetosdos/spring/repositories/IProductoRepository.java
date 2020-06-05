package com.objetosdos.spring.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Producto;


@Repository
public interface IProductoRepository extends JpaRepository<Producto, Serializable>{
	
	public abstract Producto findById(int id);
	public abstract Producto findByDescripcion(String desc);

}
