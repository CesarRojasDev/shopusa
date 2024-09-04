package com.shopusa.server.service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.exeption.ProductoNotFoundExeption;
import com.shopusa.server.mapper.ProductoMapper;
import com.shopusa.server.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
public class ProductoServiceImpl implements  ProductoService{

    @Autowired
    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;

    @Override
    public List<Producto> getAllProductos() {return productoRepository.findAll();}

    @Override
    public Producto getProductoById(String id) {
        return findProductoById(id);
    }
    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = productoMapper.INSTANCE.toProducto(productoDTO);
        producto.setPrecioSoles(calculatePrecioSoles(producto.getPrecioUSD()));
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.INSTANCE.toProductoDTO(savedProducto);
    }
    @Override
    public ProductoDTO updateProducto(String id,ProductoDTO productoDTO) {
        Producto existingProducto = findProductoById(id);
        existingProducto.setPrecioSoles(calculatePrecioSoles(existingProducto.getPrecioUSD()));
        productoMapper.INSTANCE.updateProductoFromDto(productoDTO, existingProducto);
        Producto savedProducto = productoRepository.save(existingProducto);
        return productoMapper.INSTANCE.toProductoDTO(savedProducto);
    }
    @Override
    public void deleteProducto(String id) {
        Producto producto = findProductoById(id);
        productoRepository.delete(producto);
    }
    private Producto findProductoById(String id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundExeption("Producto no encontrado con id " + id));
    }

    private double calculatePrecioSoles(double precioUSD) {
        BigDecimal tipoCambio = new BigDecimal("3.80");
        BigDecimal precioUSDBigDecimal = new BigDecimal(Double.toString(precioUSD));
        BigDecimal precioSoles = precioUSDBigDecimal.multiply(tipoCambio);
        precioSoles = precioSoles.setScale(2, RoundingMode.HALF_UP);
        return precioSoles.doubleValue();
    }
}
