package com.shopusa.server.service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(String id);
    ProductoDTO createProducto(ProductoDTO productoDTO);
//    Producto createProducto(Producto producto);
    ProductoDTO updateProducto(Producto producto);
    void deleteProducto(String id);
}
