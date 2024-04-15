package com.babel.McDonalds.service;

import com.babel.McDonalds.model.Empleado;

public interface IEmpleadoService {

    void inicializarEmpleados();

    Empleado getEmployeeByDNI(String dni);

}
