package com.babel.McDonalds.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.babel.McDonalds.model.Empleado;

@Repository
public class FakeEmpleadoDB implements IFakeEmpleadoDB{

    private List<Empleado> listaEmpleados;

    @Override
    public void inicializarEmpleados() {
        listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("123456789A", "John Smith", "Warehouse Associate"));
        listaEmpleados.add(new Empleado("987654321B", "Emily Johnson", "Delivery Driver"));
        listaEmpleados.add(new Empleado("456789123C", "Michael Brown", "Operations Manager"));
        listaEmpleados.add(new Empleado("654321987D", "Samantha Davis", "Customer Service Representative"));
        listaEmpleados.add(new Empleado("321654987E", "David Wilson", "Logistics Coordinator"));
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return listaEmpleados;
    }
}

