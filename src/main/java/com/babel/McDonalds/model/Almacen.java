package com.babel.McDonalds.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.HashMap;

public class Almacen {

    @Schema(description = "Mapa con el producto y la cantidad de unidades existentes en el Almacén")
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
