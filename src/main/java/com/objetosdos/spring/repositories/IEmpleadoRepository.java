package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Empleado;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Integer>{

}
