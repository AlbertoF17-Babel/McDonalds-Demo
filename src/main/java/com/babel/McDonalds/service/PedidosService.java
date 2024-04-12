package com.babel.McDonalds.service;

import com.babel.McDonalds.Exceptions.PedidoException;
import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.repository.IFakeAlmacenDB;
import com.babel.McDonalds.repository.IFakePedidosDB;
import com.babel.McDonalds.repository.IFakeProductoDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService implements IPedidosService{

    private final IFakePedidosDB fakePedidosDB;
    private final IFakeAlmacenDB fakeAlmacenDB;
    private final IFakeProductoDB fakeProductoDB;
    private final IAlmacenService almacenService;

    public PedidosService (IFakePedidosDB fakePedidosDB, IFakeAlmacenDB fakeAlmacenDB, IFakeProductoDB fakeProductoDB, IAlmacenService almacenService) {
        this.fakePedidosDB = fakePedidosDB;
        this.fakeAlmacenDB = fakeAlmacenDB;
        this.fakeProductoDB = fakeProductoDB;
        this.almacenService = almacenService;
    }
    @Override
    public List<Pedido> getPedidos() {
        return fakePedidosDB.getPedidos();
    }

    @Override
    public Integer crearPedido() {
        return fakePedidosDB.crearNuevoPedido().getId();
    }

    @Override
    public Pedido addProductoPedido(Integer idPedido, int idProducto){
        try {
            Pedido pedido = fakePedidosDB.findPedidoById(idPedido);
            Producto producto = fakeProductoDB.encontrarProducto(idProducto);
            almacenService.popProducto(idProducto);
            fakePedidosDB.addProducto(pedido, producto);
            return pedido;
        } catch (PedidoException | ProductoException e) {
            return null;
        }
    }

    @Override
    public Pedido asignarEmpleadoPedido(Empleado empleado) {
        return null;
    }

    @Override
    public Pedido finalizarPedido(Integer idPedido) {

        try {
            Pedido pedido = fakePedidosDB.findPedidoById(idPedido);
            pedido.setPedidoFinalizado(true);
            return pedido;
        } catch (PedidoException e) {
            return null;
        }

    }

}
