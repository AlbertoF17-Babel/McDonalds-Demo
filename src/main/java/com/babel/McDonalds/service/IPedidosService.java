package com.babel.McDonalds.service;

import com.babel.McDonalds.Exceptions.PedidoException;
import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;

import java.util.List;

public interface IPedidosService {
    List<Pedido> getPedidos ();

    Integer crearPedido ();

    Pedido addProductoPedido(Integer idPedido, int idProducto);

    Pedido asignarEmpleadoPedido(Empleado empleado);

    Pedido finalizarPedido(Integer idPedido);

}
