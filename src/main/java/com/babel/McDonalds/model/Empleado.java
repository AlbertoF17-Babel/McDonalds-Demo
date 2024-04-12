package com.babel.McDonalds.model;

public class Empleado {
    String dni;
     String name;
     String position;

    public Empleado() {}

    public Empleado(String dni, String name, String position) {
        this.dni = dni;
        this.name = name;
        this.position = position;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    
}
