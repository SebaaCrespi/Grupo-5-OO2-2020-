package com.objetosdos.spring.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Producto;

@Repository
public interface IProductoRepository extends JpaRepository <Producto,Integer>{

	public abstract Producto findById(int id); 
}
