package com.babel.McDonalds.model;

import com.babel.McDonalds.service.IPedidosService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


public class Pedido {

    private Integer id;
    private Empleado empleadoAsignado;
    private List<Producto> productos;
    private boolean pedidoFinalizado;

    public Pedido() {
        this.productos = new ArrayList<>();
        this.pedidoFinalizado = false;
    }
    public Pedido(Integer id) {
        this.id = id;
        this.productos = new ArrayList<>();
        this.pedidoFinalizado = false;
    }
    /*public Pedido(String id, Empleado empleadoAsignado, List<Producto> productos) {
        this.id = id;
        this.empleadoAsignado = empleadoAsignado;
        this.productos = productos;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empleado getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public void setEmpleadoAsignado(Empleado empleadoAsignado) {
        this.empleadoAsignado = empleadoAsignado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public boolean isPedidoFinalizado() {
        return pedidoFinalizado;
    }

    public void setPedidoFinalizado(boolean pedidoFinalizado) {
        this.pedidoFinalizado = pedidoFinalizado;
    }
}
