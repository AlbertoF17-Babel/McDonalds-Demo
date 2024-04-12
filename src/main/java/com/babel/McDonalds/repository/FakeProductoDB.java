package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class FakeProductoDB implements IFakeProductoDB {

    private List<Producto> listaProductos;

    @Override
    public List<Producto> inicializarProductos() {
        listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(1, "Big Mac", 6.25));
        listaProductos.add(new Producto(2, "CheeseBurguer", 4.75));
        listaProductos.add(new Producto(3, "CBO", 6.25));
        listaProductos.add(new Producto(4, "Cuarto de Libra", 5.65));
        listaProductos.add(new Producto(5, "McPollo", 5.75));
        listaProductos.add(new Producto(6, "McExtreme Bacon", 7.25));
        listaProductos.add(new Producto(7, "Happy Meal Burguer", 4.25));
        listaProductos.add(new Producto(8, "Patatas normales", 2.50));
        listaProductos.add(new Producto(9, "Patatas deluxe", 3.65));
        listaProductos.add(new Producto(10, "Nuggets", 3.50));
        listaProductos.add(new Producto(11, "Coca-Cola", 1.80));
        listaProductos.add(new Producto(12, "Agua", 1.25));
        listaProductos.add(new Producto(13, "Aquarius", 1.50));
        listaProductos.add(new Producto(14, "Sprite", 1.65));
        listaProductos.add(new Producto(15, "McFlurry", 2.25));
        listaProductos.add(new Producto(16, "Manzana", 1.50));
        listaProductos.add(new Producto(17, "Cono de Helado", 1.75));
        listaProductos.add(new Producto(18, "Sundae", 1.85));
        return listaProductos;
    }


    @Override
    public List<Producto> listarProductos() {
        return listaProductos;
    }

    @Override
    public Producto encontrarProducto(int idProducto) throws ProductoException {
        for (Producto producto : listaProductos) {
            if (producto.getIdProducto() == idProducto){
                return producto;
            }
        }
        throw new ProductoException("No existe ningún producto con este id");
    }


}