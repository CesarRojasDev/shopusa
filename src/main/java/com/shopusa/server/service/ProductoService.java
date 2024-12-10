package com.shopusa.server.service;

import java.util.List;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto getProductoById(String id);
    Producto getProductoBySku(String sku);
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(String id,ProductoDTO productoDTO);
    void deleteProducto(String id);
}
