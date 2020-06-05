package com.objetosdos.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.objetosdos.spring.entities.Gerente;

@Repository
public interface IGerenteRepository extends JpaRepository<Gerente,Integer>{
    
    public abstract Gerente findById(int id);
    public abstract Gerente findByDni(long dni);
    
}