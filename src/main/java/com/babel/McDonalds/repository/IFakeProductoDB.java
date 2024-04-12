package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;

import java.util.List;
import java.util.NoSuchElementException;

public interface IFakeProductoDB {

    public List<Producto> inicializarProductos();

    public List<Producto> listarProductos();

    public Producto encontrarProducto(int idProducto) throws ProductoException;
}
