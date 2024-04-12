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

    @GetMapping(path = "/all")
    public List<Pedido> getListadoDePedidos () {
        return pedidosService.getPedidos();
    }

    @PostMapping(path = "/newOrder")
    public Integer crearPedido () {
        return pedidosService.crearPedido();
    }

    @PutMapping(path = "/{orderId}/addProducts")
    public Pedido editarPedido (@PathVariable Integer orderId, @RequestBody int idProducto) {
        return pedidosService.addProductoPedido(orderId, idProducto);
    }

    @PutMapping(path = "/{orderId}/assignEmployee")
    public Pedido editarPedido (@PathVariable Integer orderID, @RequestBody Empleado empleado) {
        return pedidosService.asignarEmpleadoPedido(empleado);
    }

    @PutMapping(path = "/{orderID}/close/")
    public Pedido finalizarPedido (@PathVariable Integer idPedido) {
        return pedidosService.finalizarPedido(idPedido);
    }
}
