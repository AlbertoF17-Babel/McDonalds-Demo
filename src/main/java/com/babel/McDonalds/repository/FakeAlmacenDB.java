package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class FakeAlmacenDB implements IFakeAlmacenDB{

    HashMap<Producto, Integer> almacen;

    @Override
    public void inicializarAlmacen() {
        almacen = new HashMap<>();
    }

    @Override
    public void updateProducto(int idProducto, int nuevaCantidad) {
        for (HashMap.Entry<Producto, Integer> entry : almacen.entrySet()) {
            Producto producto = entry.getKey();
            if (producto.getIdProducto() == idProducto) {
                entry.setValue(nuevaCantidad);
            }
        }
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

}
