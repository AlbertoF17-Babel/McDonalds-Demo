package com.babel.McDonalds.model;

import java.util.List;

public class Plantilla {
     List<Empleado> employees;

    public Plantilla(List<Empleado> employees) {
        this.employees = employees;
    }

    public List<Empleado> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Empleado> employees) {
        this.employees = employees;
    }

    
}
