package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;

import java.util.HashMap;

public interface IFakeAlmacenDB {

    public void inicializarAlmacen();

    public void updateProducto(int idProducto, int nuevaCantidad);

    public HashMap<Producto, Integer> obtenerCantidadProducto(int idProducto) throws ProductoException;

    public HashMap<String, Integer> obtenerNombreYCantidadProducto(int idProducto) throws ProductoException;
}
