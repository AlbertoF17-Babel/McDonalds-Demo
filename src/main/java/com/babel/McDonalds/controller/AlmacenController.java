package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IAlmacenService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping(value = "/product/{idProducto}")
    public HashMap<String, Integer> obtenerCantidadProducto(@PathVariable int idProducto) {
        return almacenService.obtenerNombreYCantidadProducto(idProducto);
    }

    @PostMapping(value = "/push/{idProducto}")
    public int pushProducto(@PathVariable int idProducto) {
        almacenService.pushProducto(idProducto);
        return 1;
    }

    @PostMapping(value = "/pop/{idProducto}")
    public int popProducto(@PathVariable int idProducto) {
        almacenService.popProducto(idProducto);
        return 1;
    }

}
