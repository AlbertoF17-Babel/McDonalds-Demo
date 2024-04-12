package com.babel.McDonalds.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.repository.FakeEmpleadoDB;
import com.babel.McDonalds.repository.IFakeEmpleadoDB;

@Service
public class EmpleadoService implements IEmpleadoService {

    private final String FakeEmployeeDB = null;
    private final IFakeEmpleadoDB iFakeEmployeeDB;

    public EmpleadoService(IFakeEmpleadoDB iFakeEmployeeDB) {
        this.iFakeEmployeeDB = iFakeEmployeeDB;
    }

    public void chargeEmployeeList() {
        this.FakeEmployeeDB.initialEmployeeList();
    }

    List<Empleado> employeeList = new ArrayList<>();

    public List<Empleado> getAllEmployees() {
        return employeeList;
    }

    public void addEmployee(Empleado employee) {
        boolean exists = employeeList.stream().anyMatch(e -> e.getDni().equals(employee.getDni()));
        if (!exists) {
            employeeList.add(employee);
        }
    }

    public void removeEmployee(String dni) {
        employeeList.removeIf(employee -> employee.getDni().equals(dni));
    }

    public Empleado getEmployeeByDNI(String dni) {
        for (Empleado employee : employeeList ) {
            if (employee.getDni().equals(dni)) {
                return employee;
            }
        }
        return null;
    }

}
