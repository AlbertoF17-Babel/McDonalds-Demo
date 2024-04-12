package com.babel.McDonalds.repository;

import java.util.List;

import com.babel.McDonalds.model.Empleado;

public interface IFakeEmpleadoDB {
    
    void inicializarEmpleados();

    List<Empleado> listarEmpleados();
}
