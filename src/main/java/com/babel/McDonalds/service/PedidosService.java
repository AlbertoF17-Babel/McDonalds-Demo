package com.babel.McDonalds.service;

import com.babel.McDonalds.Exceptions.PedidoException;
import com.babel.McDonalds.Exceptions.ProductoException;
import com.babel.McDonalds.model.Empleado;
import com.babel.McDonalds.model.Pedido;
import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.repository.IFakeAlmacenDB;
import com.babel.McDonalds.repository.IFakeEmpleadoDB;
import com.babel.McDonalds.repository.IFakePedidosDB;
import com.babel.McDonalds.repository.IFakeProductoDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosService implements IPedidosService{

    private final IFakePedidosDB fakePedidosDB;
    private final IFakeAlmacenDB fakeAlmacenDB;
    private final IFakeProductoDB fakeProductoDB;
    private final IFakeEmpleadoDB fakeEmpleadoDB;
    private final IAlmacenService almacenService;
    private final IEmpleadoService empleadoService;

    public PedidosService (IFakePedidosDB fakePedidosDB, IFakeAlmacenDB fakeAlmacenDB, IFakeProductoDB fakeProductoDB,
                           IFakeEmpleadoDB fakeEmpleadoDB, IAlmacenService almacenService, IEmpleadoService empleadoService) {
        this.fakePedidosDB = fakePedidosDB;
        this.fakeAlmacenDB = fakeAlmacenDB;
        this.fakeProductoDB = fakeProductoDB;
        this.fakeEmpleadoDB = fakeEmpleadoDB;
        this.almacenService = almacenService;
        this.empleadoService = empleadoService;
    }
    @Override
    public List<Pedido> getPedidos() {
        return fakePedidosDB.getPedidos();
    }

    public Pedido getPedido(Integer idPedido) {
        try {
            return fakePedidosDB.findPedidoById(idPedido);
        } catch (PedidoException e) {
            return null;
        }
    }

    public List<Producto> getProductos(Integer idPedido) {
        try {
            Pedido pedido = fakePedidosDB.findPedidoById(idPedido);
            return pedido.getProductos();
        } catch (PedidoException e) {
            return null;
        }
    }
    @Override
    public Integer crearPedido() {
        return fakePedidosDB.crearNuevoPedido().getId();
    }

    @Override
    public Pedido addProductoPedido(Integer idPedido, int idProducto){
        try {
            Pedido pedido = fakePedidosDB.findPedidoById(idPedido);
            if (pedido.isPedidoFinalizado()) {
                return null;
            }
            Producto producto = fakeProductoDB.encontrarProducto(idProducto);
            almacenService.popProducto(idProducto);
            fakePedidosDB.addProducto(pedido, producto);
            return pedido;
        } catch (PedidoException | ProductoException e) {
            return null;
        }
    }

    @Override
    public Pedido asignarEmpleadoPedido(Integer idPedido, String empleadoDni) {
        try {
            Pedido pedido = fakePedidosDB.findPedidoById(idPedido);
            if (pedido.isPedidoFinalizado()) {
                return null;
            }
            System.out.println(empleadoService.getEmployeeByDNI(empleadoDni));
            pedido.setEmpleadoAsignado(empleadoService.getEmployeeByDNI(empleadoDni));
            return pedido;
        } catch (PedidoException e) {
            return null;
        }
    }

    @Override
    public Pedido finalizarPedido(Integer idPedido) {
        try {
            Pedido pedido = fakePedidosDB.findPedidoById(idPedido);
            if (pedido.isPedidoFinalizado()) {
                return null;
            }
            pedido.setPedidoFinalizado(true);
            return pedido;
        } catch (PedidoException e) {
            return null;
        }

    }

}
