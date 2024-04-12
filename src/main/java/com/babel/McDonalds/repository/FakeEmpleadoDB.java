package com.babel.McDonalds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babel.McDonalds.model.Empleado;

@Repository
public class FakeEmpleadoDB implements IFakeEmpleadoDB{

    private List<Empleado> employeeList;

    @Override
    public void initialEmployeeList() {
        employeeList = new ArrayList<>();
        employeeList.add(new Empleado("123456789A", "John Smith", "Warehouse Associate"));
        employeeList.add(new Empleado("987654321B", "Emily Johnson", "Delivery Driver"));
        employeeList.add(new Empleado("456789123C", "Michael Brown", "Operations Manager"));
        employeeList.add(new Empleado("654321987D", "Samantha Davis", "Customer Service Representative"));
        employeeList.add(new Empleado("321654987E", "David Wilson", "Logistics Coordinator"));
    }

    @Override
    public List<Empleado> employeeList() {
        return employeeList;
    }
}

