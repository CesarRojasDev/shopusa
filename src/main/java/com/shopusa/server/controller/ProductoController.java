package com.shopusa.server.controller;


import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getProductos(){return productoService.getAllProductos();}

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable String id){
        return productoService.getProductoById(id);
    }
    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO){
        return productoService.createProducto(productoDTO);
    }
}
