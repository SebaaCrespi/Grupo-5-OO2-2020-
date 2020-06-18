package com.objetosdos.spring.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Vendedor;


@Repository
public interface IVendedorRepository extends JpaRepository <Vendedor, Serializable> {
	
	public abstract Vendedor findByIdPersona(int id);
	public abstract Vendedor findByDni(long dni);

	@Query("FROM Vendedor v JOIN v.sucursal s where s.id = (:idSucursal)")
    public abstract List<Vendedor> traerVendedoresDeSucursal(int idSucursal);

}
