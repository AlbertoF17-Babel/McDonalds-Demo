package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IAlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/store")
public class AlmacenController {

    private final IAlmacenService almacenService;

    public AlmacenController(IAlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return almacenService.listarProductos();
    }

    @GetMapping(value = "/product/{idProducto}")
    public void obtenerCantidadProducto(@PathVariable int idProducto) {
        almacenService.obtenerCantidadProducto(idProducto);
    }

    @GetMapping(value = "/push/{idProducto}")
    public void pushProducto(@PathVariable int idProducto) {
        almacenService.pushProducto(idProducto);
    }

    @GetMapping(value = "/pop/{idProducto}")
    public void popProducto(@PathVariable int idProducto) {
        almacenService.popProducto(idProducto);
    }

}
