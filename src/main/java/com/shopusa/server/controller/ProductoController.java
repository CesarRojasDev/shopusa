package com.shopusa.server.controller;


import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getProductos(){return productoService.getAllProductos();}

    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO){
        return productoService.createProducto(productoDTO);
    }
//        @PostMapping
//    public Producto createProducto(@RequestBody Producto producto){
//        return productoService.createProducto(producto);
//    }
}
