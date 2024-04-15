package com.babel.McDonalds.repository;

import com.babel.McDonalds.Exceptions.PedidoException;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakePedidosDB implements IFakePedidosDB {
    private List<Pedido> pedidoRepository;
    private static Integer lastId = 0;
    public FakePedidosDB() {
        this.pedidoRepository = new ArrayList<>();
    }

    public List<Pedido> getPedidos() {
        return pedidoRepository;
    }

    public Pedido crearNuevoPedido() {
        lastId++;
        Pedido pedido = new Pedido(lastId);
        pedidoRepository.add(pedido);
        return pedido;
    }

    public Pedido findPedidoById (Integer pedidoId) throws PedidoException {
        for(Pedido pedido : pedidoRepository) {
            if (pedido.getId().equals(pedidoId)) {
                return pedido;
            }
        }
        throw new PedidoException("Pedido no encontrado");
    }

    @Override
    public boolean addProducto(Pedido pedido, Producto producto) throws PedidoException {

        pedido.getProductos().add(producto);

        return true;
    }


}
