package com.objetosdos.spring.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Lote;
import com.objetosdos.spring.entities.Producto;

@Repository
public interface ILoteRepository extends JpaRepository<Lote, Serializable>{
	
	public abstract Lote findByIdLote(int id);

	@Query("select p.marca FROM Lote l JOIN l.producto p GROUP BY p.marca")
	public abstract List<String> getAllMarca();
	
	@Query("select l.talle FROM Lote l JOIN l.producto p where p.marca = (:marca)"+" and p.descripcion = (:descripcion) GROUP BY l.talle")
    public abstract List<String> getAllTalle(String marca,String descripcion);

	@Query("select p.descripcion FROM Lote l JOIN l.producto p where p.marca =  (:marca)GROUP BY p.descripcion")
	public abstract List<String> getAllDescripcion(String marca);
	
	@Query("FROM Lote l JOIN l.producto p where p.marca = (:marca)"+" and p.descripcion = (:descripcion)" + " and l.talle = (:talle)")
    public abstract List<Lote> getBusquedaProducto(String marca, String descripcion, String talle);
	
	@Query("FROM Lote l JOIN l.producto p where p.marca = (:marca)"+" and p.descripcion = (:descripcion)" + " and l.talle = (:talle)"+"and cantidad= (:cantidadActual)")
    public abstract List<Lote> getBusquedaProductoyCantidad(String marca, String descripcion, String talle, int cantidadActual);
	
	@Query("select p.descripcion FROM Lote l JOIN l.producto p where l.sucursal = (:id)")
	public abstract List<Producto> getAllProductoSuc(int id);
}


