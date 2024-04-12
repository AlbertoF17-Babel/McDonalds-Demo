package com.babel.McDonalds.repository;

import com.babel.McDonalds.model.Producto;

import java.util.List;

public interface IFakeProductoDB {

    public List<Producto> inicializarProductos();

    List<Producto> listarProductos();
}
