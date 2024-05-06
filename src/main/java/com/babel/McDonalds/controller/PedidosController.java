package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IPedidosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")
public class PedidosController {
    private final IPedidosService pedidosService;

    public PedidosController (IPedidosService pedidosService){
        this.pedidosService = pedidosService;
    }

    @GetMapping
    @Operation(summary = "Listado productos")
    public List<Pedido> getListadoDePedidos () {
        return pedidosService.getPedidos();
    }

    @PostMapping
    @Operation(summary = "Creación de pedido")
    public Integer crearPedido () {
        return pedidosService.crearPedido();
    }

    @GetMapping(path = "/{orderId}")
    @Operation(summary = "Recuperar producto por id")
    public Pedido getPedidoById (@PathVariable Integer orderId) {
        return pedidosService.getPedido(orderId);
    }

    @PostMapping(path = "/{orderID}")
    @Operation(summary = "Finalizar pedido")
    public Pedido finalizarPedido (@PathVariable Integer orderID) {
        return pedidosService.finalizarPedido(orderID);
    }

    @GetMapping(path = "/{orderId}/products")
    @Operation(summary = "Listado de productos por id de pedido")
    public List<Producto> getProductosByPedido (@PathVariable Integer orderId) {
       return pedidosService.getProductos(orderId);
    }

    @PostMapping(path = "/{orderId}/products/{productId}")
    @Operation(summary = "Añadir producto al pedido por id de pedido e id de producto")
    public Pedido editarPedido (@PathVariable Integer orderId, @PathVariable int productId) {
        return pedidosService.addProductoPedido(orderId, productId);
    }

    @PutMapping(path = "/{orderId}/employee/{employeeDni}")
    @Operation(summary = "Asignar empleado al pedido por id de pedido y dni del empleado")
    public Pedido addEmpleado (@PathVariable Integer orderId, @PathVariable String employeeDni) {
        return pedidosService.asignarEmpleadoPedido(orderId, employeeDni);
    }


}
