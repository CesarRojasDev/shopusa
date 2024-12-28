package com.shopusa.server.service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    Page<Producto> getAllProductosPaginados(Pageable pegeable);
    List<Producto> getAllProductos();
    Producto getProductoById(String id);
    Producto getProductoBySku(String sku);
    Page<Producto> searchProductsByName(String nombre,Pageable pageable);
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(String id,ProductoDTO productoDTO);
    void deleteProducto(String id);
}
