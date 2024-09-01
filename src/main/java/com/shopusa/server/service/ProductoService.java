package com.shopusa.server.service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;

import java.util.List;


public interface ProductoService {
    List<Producto> getAllProductos();
    Producto getProductoById(String id);
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(String id,ProductoDTO productoDTO);
    void deleteProducto(String id);
}
