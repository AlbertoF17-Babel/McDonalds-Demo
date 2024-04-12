package com.babel.McDonalds.service;

import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.repository.IFakeAlmacenDB;
import com.babel.McDonalds.repository.IFakeProductoDB;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AlmacenService implements IAlmacenService {

    private final IFakeAlmacenDB almacenDB;
    private final IFakeProductoDB productoDB;

    public AlmacenService(IFakeAlmacenDB almacenDB, IFakeProductoDB productoDB) {
        this.almacenDB = almacenDB;
        this.productoDB = productoDB;
    }

    @Override
    public void inicializarAlmacen() {
        List<Producto> listaProductos = this.productoDB.inicializarProductos();
        this.almacenDB.inicializarAlmacen();
        for (Producto producto : listaProductos) {
            pushProducto(producto.getIdProducto());
        }
    }

    @Override
    public HashMap<Producto, Integer> obtenerCantidadProducto(int idProducto) {
        return this.almacenDB.obtenerCantidadProducto(idProducto);
    }

    @Override
    public List<Producto> listarProductos() {
        return this.productoDB.listarProductos();
    }

    @Override
    public void pushProducto(int idProducto) {
        HashMap<Producto, Integer> productoCantidad = obtenerCantidadProducto(idProducto);
        if (productoCantidad != null) {
            int cantidadProducto = productoCantidad.get(idProducto)+1;
            this.almacenDB.updateProducto(idProducto, cantidadProducto);
        }
    }

    @Override
    public void popProducto(int idProducto) throws NoSuchElementException {
        HashMap<Producto, Integer> productoCantidad = obtenerCantidadProducto(idProducto);
        if (productoCantidad != null) {
            int cantidadProducto = productoCantidad.get(idProducto);
            if (cantidadProducto == 0) {
                throw new NoSuchElementException("El producto con ID " + idProducto + " no está en stock");
            } else {
                cantidadProducto--;
                this.almacenDB.updateProducto(idProducto, cantidadProducto);
            }
        }
    }


}
