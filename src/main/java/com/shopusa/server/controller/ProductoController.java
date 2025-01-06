package com.shopusa.server.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.shopusa.server.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
    @Autowired
    private ExcelService excelService;

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
    @GetMapping("/filter")
    public Page<Producto> searchBySubCategoria(
            @PageableDefault(size = 16, sort = "nombre") Pageable pageable,
            @RequestParam("subcategoria") String subcategoria
    ){
        return productoService.searchBySubCategoria(subcategoria,pageable);
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
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> exportProductosToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportProductosToExcel();
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String fileName = "SHOPUSA-PRODUCTOS-" + formattedDate + ".xlsx";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+fileName);
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
