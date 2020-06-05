package com.objetosdos.spring.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Pedido;


@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Serializable> {
	
	 public abstract Pedido findByIdPedido(int id);

}
