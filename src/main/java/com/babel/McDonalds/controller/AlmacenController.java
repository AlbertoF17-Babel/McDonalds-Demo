package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IAlmacenService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Muestra todos los productos disponibles en el almacén, con su ID y su precio")
    public List<Producto> listarProductos() {
        return almacenService.listarProductos();
    }

    @PostMapping(value = "/product/{idProducto}")
    @Operation(summary = "Muestra el producto según el ID y su stock en el almacén")
    public HashMap<String, Integer> obtenerCantidadProducto(@PathVariable int idProducto) {
        return almacenService.obtenerNombreYCantidadProducto(idProducto);
    }

    @PostMapping(value = "/push/{idProducto}")
    @Operation(summary = "Añade una unidad al stock del producto según su ID al almacén")
    public int pushProducto(@PathVariable int idProducto) {
        almacenService.pushProducto(idProducto);
        return 1;
    }

    @PostMapping(value = "/pop/{idProducto}")
    @Operation(summary = "Resta una unidad al stock del producto según su ID al almacén")
    public int popProducto(@PathVariable int idProducto) {
        almacenService.popProducto(idProducto);
        return 1;
    }

}
