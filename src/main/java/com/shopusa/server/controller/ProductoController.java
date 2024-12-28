package com.shopusa.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping("/paginados")
    public Page<Producto> getProductosPaginados(Pageable pageable){
        return productoService.getAllProductosPaginados(pageable);
    }
    @GetMapping
    public List<Producto> getProductos(){
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable String id){
        return productoService.getProductoById(id);
    }

    @GetMapping("/sku/{sku}")
    public Producto getProductoBySku(@PathVariable String sku){
        return productoService.getProductoBySku(sku);
    }

    @GetMapping("/search")
    public Page<Producto> searchByName(
            @PageableDefault(size = 16, sort = "nombre") Pageable pageable,
            @RequestParam("nombre") String nombre
    ){
        return productoService.searchProductsByName(nombre,pageable);
    }
    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO){
        return productoService.createProducto(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO updateProducto(@PathVariable String id, @RequestBody ProductoDTO productoDTO){
        return productoService.updateProducto(id,productoDTO);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable String id){
        productoService.deleteProducto(id);
    }
}
