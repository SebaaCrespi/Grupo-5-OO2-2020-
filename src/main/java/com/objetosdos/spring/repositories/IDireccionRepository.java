package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Direccion;

@Repository
public interface IDireccionRepository extends JpaRepository <Direccion,Integer>{

}
