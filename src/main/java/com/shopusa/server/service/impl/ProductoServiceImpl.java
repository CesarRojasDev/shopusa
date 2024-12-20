package com.shopusa.server.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.exeption.ProductoNotFoundExeption;
import com.shopusa.server.mapper.ProductoMapper;
import com.shopusa.server.repository.ProductoRepository;
import com.shopusa.server.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    private ProductoMapper productoMapper;

    @Override
    public Page<Producto> getAllProductosPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductoById(String id) {
        return findProductoById(id);
    }

    @Override
    public Producto getProductoBySku(String sku) {
        return productoRepository.findBySku(sku);
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
        productoMapper.INSTANCE.updateProductoFromDto(productoDTO, existingProducto);
        existingProducto.setPrecioSoles(calculatePrecioSoles(existingProducto.getPrecioUSD()));
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
        BigDecimal precioEnvio = BigDecimal.valueOf(20.0);

        // Convertir el precio en USD a soles con el costo de envío
        BigDecimal precioUSDBigDecimal = BigDecimal.valueOf(precioUSD).add(precioEnvio);
        System.out.println("Precio en USD: " + precioUSDBigDecimal);

        // Calcular el precio en soles
        BigDecimal precioSoles = precioUSDBigDecimal.multiply(tipoCambio);
        precioSoles = precioSoles.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Precio en Soles: " + precioSoles);

        // Calcular el precio final considerando la ganancia
        BigDecimal gananciaFactor = BigDecimal.valueOf(1 - 0.14);  // 1 - 0.14 = 0.86
        BigDecimal precioFinal = precioSoles.divide(gananciaFactor, RoundingMode.HALF_UP);  // Dividir por 0.86 para agregar la ganancia
        precioFinal = precioFinal.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Precio Final: " + precioFinal);

        return precioFinal.doubleValue();
    }
}
