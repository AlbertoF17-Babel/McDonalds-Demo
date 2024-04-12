package com.babel.McDonalds.model;

import java.util.HashMap;

public class Almacen {

    private HashMap<Producto, Integer> almacen;

    public Almacen() {
    }

    public Almacen(HashMap<Producto, Integer> almacen) {
        this.almacen = almacen;
    }

    public HashMap<Producto, Integer> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(HashMap<Producto, Integer> almacen) {
        this.almacen = almacen;
    }
}
