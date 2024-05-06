package com.babel.McDonalds.controller;


import com.babel.McDonalds.model.Producto;
import com.babel.McDonalds.service.IAlmacenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/store")
@Tag(name = "AlmacenController", description = "Controlador que posee los endpoints relacionados con las operaciones del almacén")
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
    @Operation(summary = "Muestra el producto según el ID y su stock en el almacén",
            responses = {
                    @ApiResponse(description = "Producto",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Producto.class))),
                    @ApiResponse(responseCode = "400", description = "No existe el producto con este ID")})
    public HashMap<String, Integer> obtenerCantidadProducto(@PathVariable int idProducto) {
        return almacenService.obtenerNombreYCantidadProducto(idProducto);
    }

    @PostMapping(value = "/push/{idProducto}")
    @Operation(summary = "Añade una unidad al stock del producto según su ID al almacén",
            responses = {
                    @ApiResponse(description = "Producto",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Producto.class))),
                    @ApiResponse(responseCode = "400", description = "No existe el producto con este ID")})
    public int pushProducto(@PathVariable int idProducto) {
        almacenService.pushProducto(idProducto);
        return 1;
    }

    @PostMapping(value = "/pop/{idProducto}")
    @Operation(summary = "Resta una unidad al stock del producto según su ID al almacén",
            responses = {
                    @ApiResponse(description = "Producto",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Producto.class))),
                    @ApiResponse(responseCode = "400", description = "No existe el producto con este ID")})
    public int popProducto(@PathVariable int idProducto) {
        almacenService.popProducto(idProducto);
        return 1;
    }

}
