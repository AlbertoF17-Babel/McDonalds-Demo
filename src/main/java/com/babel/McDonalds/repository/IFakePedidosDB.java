package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.PedidoException;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;

import java.util.List;

public interface IFakePedidosDB {
    List<Pedido> getPedidos();
    Pedido crearNuevoPedido();

    public Pedido findPedidoById (Integer pedidoId) throws PedidoException;
    public boolean addProducto (Pedido pedido, Producto producto) throws PedidoException;
}
