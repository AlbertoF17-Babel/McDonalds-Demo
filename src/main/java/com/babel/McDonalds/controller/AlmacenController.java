package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IAlmacenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/store")
public class AlmacenController {

    private final IAlmacenService almacenService;

    public AlmacenController(IAlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping(value = "/product")
    public void obtenerCantidadProducto(@RequestBody int idProducto) {
        almacenService.obtenerCantidadProducto(idProducto);
    }

    @GetMapping(value = "/list")
    public List<Producto> listarProductos() {
        return almacenService.listarProductos();
    }

    @GetMapping(value = "/push")
    public void pushProducto(@RequestBody int idProducto) {
        almacenService.pushProducto(idProducto);
    }

    @GetMapping(value = "/pop")
    public void popProducto(@RequestBody int idProducto) {
        almacenService.popProducto(idProducto);
    }

}
