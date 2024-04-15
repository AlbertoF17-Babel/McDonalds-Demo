package com.babel.McDonalds.service;

import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;

import java.util.List;

public interface IPedidosService {
    List<Pedido> getPedidos ();
    Pedido getPedido (Integer orderId);

    Integer crearPedido ();

    public List<Producto> getProductos(Integer idPedido);

    Pedido addProductoPedido(Integer idPedido, int idProducto);

    Pedido asignarEmpleadoPedido(Integer idPedido, String empleadoDni);

    Pedido finalizarPedido(Integer idPedido);

}
