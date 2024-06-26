package com.babel.McDonalds.service;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.repository.IFakeAlmacenDB;
import com.babel.McDonalds.repository.IFakeProductoDB;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AlmacenService implements IAlmacenService {

    private final IFakeAlmacenDB almacenDB;
    private final IFakeProductoDB productoDB;

    public AlmacenService(IFakeAlmacenDB almacenDB, IFakeProductoDB productoDB) {
        this.almacenDB = almacenDB;
        this.productoDB = productoDB;
    }

    @Override
    public void inicializarAlmacen(){
        this.almacenDB.inicializarAlmacen();
    }

    @Override
    public HashMap<Producto, Integer> obtenerCantidadProducto(int idProducto){
        try {
            return this.almacenDB.obtenerCantidadProducto(idProducto);
        } catch (ProductoException e){
            return null;
        }
    }

    @Override
    public HashMap<String, Integer> obtenerNombreYCantidadProducto(int idProducto){
        try {
            return this.almacenDB.obtenerNombreYCantidadProducto(idProducto);
        } catch (ProductoException e){
            return null;
        }
    }

    @Override
    public List<Producto> listarProductos() {
        return this.productoDB.listarProductos();
    }

    @Override
    public void pushProducto(int idProducto) {
        try {
            HashMap<Producto, Integer> productoCantidad = obtenerCantidadProducto(idProducto);
            Producto producto = this.productoDB.encontrarProducto(idProducto);
            if (producto != null) {
                int cantidadProducto = productoCantidad.get(producto) + 1;
                this.almacenDB.updateProducto(idProducto, cantidadProducto);
            } else {
                throw new ProductoException("El producto con ID " + idProducto + " no existe");
            }
        } catch (ProductoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void popProducto(int idProducto){
        try{
            HashMap<Producto, Integer> productoCantidad = obtenerCantidadProducto(idProducto);
            Producto producto = this.productoDB.encontrarProducto(idProducto);
            if (productoCantidad != null) {
                int cantidadProducto = productoCantidad.get(producto);
                if (cantidadProducto == 0) {
                    throw new ProductoException("El producto con ID " + idProducto + " no está en stock");
                } else {
                    cantidadProducto--;
                    this.almacenDB.updateProducto(idProducto, cantidadProducto);
                }
            }
        } catch (ProductoException e) {
            System.out.println("El producto con ID " + idProducto + " no existe");
        }
    }


}
