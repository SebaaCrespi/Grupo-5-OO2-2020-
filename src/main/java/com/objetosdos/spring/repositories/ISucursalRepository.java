package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.objetosdos.spring.entities.Sucursal;
import com.objetosdos.spring.models.VendedorModel;


@Repository
public interface ISucursalRepository extends JpaRepository <Sucursal,Integer>{

	public abstract Sucursal findById(int id);
 
}
