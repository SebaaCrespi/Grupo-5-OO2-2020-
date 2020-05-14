package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Sucursal;


@Repository
public interface ISucursalRepository extends JpaRepository <Sucursal,Integer>{

}
