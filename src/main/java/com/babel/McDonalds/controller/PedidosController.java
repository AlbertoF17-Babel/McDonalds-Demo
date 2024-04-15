package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IPedidosService;
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
    public List<Pedido> getListadoDePedidos () {
        return pedidosService.getPedidos();
    }

    @PostMapping
    public Integer crearPedido () {
        return pedidosService.crearPedido();
    }

    @GetMapping(path = "/{orderId}")
    public Pedido getPedidoById (@PathVariable Integer orderId) {
        return pedidosService.getPedido(orderId);
    }

    @PostMapping(path = "/{orderID}")
    public Pedido finalizarPedido (@PathVariable Integer idPedido) {
        return pedidosService.finalizarPedido(idPedido);
    }

    @GetMapping(path = "/{orderId}/products")
    public List<Producto> getProductosByPedido (@PathVariable Integer orderId) {
       return pedidosService.getProductos(orderId);
    }

    @PostMapping(path = "/{orderId}/products/{productId}")
    public Pedido editarPedido (@PathVariable Integer orderId, @PathVariable int productId) {
        return pedidosService.addProductoPedido(orderId, productId);
    }

    @PutMapping(path = "/{orderId}/employee/{employeeDni}")
    public Pedido editarPedido (@PathVariable Integer orderId, @PathVariable String employeeDni) {
        return pedidosService.asignarEmpleadoPedido(orderId, employeeDni);
    }


}
