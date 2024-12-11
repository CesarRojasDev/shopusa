package com.shopusa.server.service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductoService {
    Page<Producto> getAllProductos(Pageable pegeable);
    Producto getProductoById(String id);
    Producto getProductoBySku(String sku);
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(String id,ProductoDTO productoDTO);
    void deleteProducto(String id);
}
