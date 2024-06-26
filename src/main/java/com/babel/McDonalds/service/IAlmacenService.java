package com.babel.McDonalds.service;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;

import java.util.HashMap;
import java.util.List;

public interface IAlmacenService {

    void inicializarAlmacen();

    HashMap<Producto, Integer> obtenerCantidadProducto(int idProducto);

    public HashMap<String, Integer> obtenerNombreYCantidadProducto(int idProducto);

    List<Producto> listarProductos();

    void pushProducto(int idProducto);

    void popProducto(int idProducto);

}
