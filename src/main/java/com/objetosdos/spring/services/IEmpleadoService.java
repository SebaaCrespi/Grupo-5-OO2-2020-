package com.objetosdos.spring.services;

import java.util.List;

import com.objetosdos.spring.entities.Empleado;
import com.objetosdos.spring.models.EmpleadoModel;

public interface IEmpleadoService {

    public List<Empleado> getAll();

    public EmpleadoModel insertOrUpdate(EmpleadoModel empleadoModel);

}
