package com.shopusa.server.service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.mapper.ProductoMapper;
import com.shopusa.server.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements  ProductoService{

    @Autowired
    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;
    @Override
    public List<Producto> getAllProductos() {return productoRepository.findAll();}

    @Override
    public Optional<Producto> getProductoById(String id) {
        return productoRepository.findById(id);
    }

//    @Override
//    public ProductoDTO createProducto(ProductoDTO productoDTO) {
//        Producto producto = productoMapper.INSTANCE.toProducto(productoDTO);
//        Producto savedProducto = productoRepository.save(producto);
//        return productoMapper.INSTANCE.toProductoDTO(savedProducto);
//    }
    @Override
    public Producto createProducto(Producto producto){
        return productoRepository.save(producto);
    }
    @Override
    public ProductoDTO updateProducto(Producto producto) {
        return null;
    }

    @Override
    public void deleteProducto(String id) {

    }
}
