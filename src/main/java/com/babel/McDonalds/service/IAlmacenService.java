package com.babel.McDonalds.service;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;

import java.util.HashMap;
import java.util.List;

public interface IAlmacenService {

    void inicializarAlmacen() throws ProductoException;

    HashMap<Producto, Integer> obtenerCantidadProducto(int idProducto) throws ProductoException;

    List<Producto> listarProductos();

    void pushProducto(int idProducto) throws ProductoException;

    void popProducto(int idProducto) throws ProductoException;

}
