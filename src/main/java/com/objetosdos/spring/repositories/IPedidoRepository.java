package com.objetosdos.spring.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Pedido;
import com.objetosdos.spring.models.PedidoModel;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {

  	public abstract Pedido findByIdPedido(int id);
	
	  @Query("FROM Pedido p JOIN p.vendedorAuxiliar v JOIN v.sucursal s WHERE s.id = (:id)")
    public abstract List<Pedido> traerPedidosPorSucursal(int id);
  
}
