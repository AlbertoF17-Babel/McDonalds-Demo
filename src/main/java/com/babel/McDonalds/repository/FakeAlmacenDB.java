package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class FakeAlmacenDB implements IFakeAlmacenDB{

    HashMap<Producto, Integer> almacen;
    private final IFakeProductoDB productoDB;

    public FakeAlmacenDB(IFakeProductoDB productoDB) {
        this.productoDB = productoDB;
    }

    @Override
    public void inicializarAlmacen() {
        List<Producto> listaProductos = this.productoDB.inicializarProductos();
        almacen = new HashMap<>();
        for (Producto producto : listaProductos) {
            almacen.put(producto ,1);
        }
    }

    @Override
    public void updateProducto(int idProducto, int nuevaCantidad) {
        almacen.put(new Producto(idProducto), nuevaCantidad);
    }

    @Override
    public HashMap<Producto, Integer> obtenerCantidadProducto(int idProducto) throws ProductoException {
        HashMap<Producto, Integer> productoEncontrado = new HashMap<>();
        for (HashMap.Entry<Producto, Integer> entry : almacen.entrySet()) {
            Producto producto = entry.getKey();
            if (producto.getIdProducto() == idProducto) {
                productoEncontrado.put(producto, entry.getValue());
                return productoEncontrado;
            }
        }
        throw new ProductoException("El producto con el id " + idProducto + " no existe");
    }

    @Override
    public HashMap<String, Integer> obtenerNombreYCantidadProducto(int idProducto) throws ProductoException {
        HashMap<String, Integer> productoEncontrado = new HashMap<>();
        for (HashMap.Entry<Producto, Integer> entry : almacen.entrySet()) {
            Producto producto = entry.getKey();
            if (producto.getIdProducto() == idProducto) {
                productoEncontrado.put(producto.getNombreProducto(), entry.getValue());
                return productoEncontrado;
            }
        }
        throw new ProductoException("El producto con el id " + idProducto + " no existe");
    }

}
