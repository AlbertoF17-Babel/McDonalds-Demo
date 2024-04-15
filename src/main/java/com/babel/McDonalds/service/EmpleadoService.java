package com.babel.McDonalds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.repository.IFakeEmpleadoDB;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final IFakeEmpleadoDB fakeEmpleadoDB;

    public EmpleadoService(IFakeEmpleadoDB fakeEmpleadoDB) {
        this.fakeEmpleadoDB = fakeEmpleadoDB;
    }

    public void inicializarEmpleados() {
        this.fakeEmpleadoDB.inicializarEmpleados();
    }

    //List<Empleado> listaEmpleados = new ArrayList<>();

    public List<Empleado> listarEmpleados() {
        return this.fakeEmpleadoDB.listarEmpleados();
    }

    public void addEmployee(Empleado employee) {
        boolean exists = fakeEmpleadoDB.listarEmpleados().stream().anyMatch(e -> e.getDni().equals(employee.getDni()));
        if (!exists) {
            fakeEmpleadoDB.listarEmpleados().add(employee);
        }
    }

    public void removeEmployee(String dni) {
        fakeEmpleadoDB.listarEmpleados().removeIf(employee -> employee.getDni().equals(dni));
    }

    public Empleado getEmployeeByDNI(String dni) {
        for (Empleado employee : fakeEmpleadoDB.listarEmpleados()) {
            if (employee.getDni().equalsIgnoreCase(dni)) {
                return employee;
            }
        }
        return null;
    }

}
