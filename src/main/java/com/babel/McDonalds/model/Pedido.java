package com.babel.McDonalds.model;

import com.babel.McDonalds.service.IPedidosService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


public class Pedido {

    @Schema(description = "Identificador del producto")
    private Integer id;

    @Schema(description = "Empleado asignado")
    private Empleado empleadoAsignado;
    @Schema(description = "Lista de productos")
    private List<Producto> productos;
    @Schema(description = "Boolean pedido finalizado")
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
