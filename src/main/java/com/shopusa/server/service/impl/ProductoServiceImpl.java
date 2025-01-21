package com.shopusa.server.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.shopusa.server.exeption.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
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
    public Page<Producto> searchBySubCategoria(String subcategoria, Pageable pageable) {
        return productoRepository.findBySubCategoria_id(subcategoria, pageable);
    }

    @Override
    public Page<Producto> searchProductsByName(String nombre, Pageable pageable) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre, pageable);
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        Producto producto = productoMapper.INSTANCE.toProducto(productoDTO);
        producto.setPrecioSoles(calculatePrecioSoles(producto.getPrecioUSD(), producto.getSubCategoria().getPesoGramos()));
        Producto savedProducto = productoRepository.save(producto);
        return productoMapper.INSTANCE.toProductoDTO(savedProducto);
    }

    @Override
    public ProductoDTO updateProducto(String id, ProductoDTO productoDTO) {
        Producto existingProducto = findProductoById(id);
        productoMapper.INSTANCE.updateProductoFromDto(productoDTO, existingProducto);
        existingProducto.setPrecioSoles(calculatePrecioSoles(existingProducto.getPrecioUSD(), existingProducto.getSubCategoria().getPesoGramos()));
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
                .orElseThrow(() -> new EntityNotFoundException("Producto", id));
    }

    private double calculatePrecioSoles(double precioUSD, double pesoGramos) {
        System.out.println("Peso en gramos: " + pesoGramos);
        BigDecimal tipoCambio = new BigDecimal("3.80"); // Tipo de cambio USD a Soles
        BigDecimal costoKg = BigDecimal.valueOf(8.0); // Costo por KG en USD
        BigDecimal costoAdm = BigDecimal.valueOf(9.0); // Costo de administración en USD

        // Calcular el costo de envío basado en el peso
        BigDecimal pesoKg = BigDecimal.valueOf(pesoGramos).divide(BigDecimal.valueOf(1000), RoundingMode.UP); // Convertir gramos a KG, redondear hacia arriba
        BigDecimal costoEnvioTotal = pesoKg.multiply(costoKg).add(costoAdm); // Calcular el costo de envío total
        System.out.println("Costo de Envío Total en USD: " + costoEnvioTotal);

        // Verificar si el precio USD es mayor que 220 y aplicar el ajuste
        BigDecimal precioUSDBigDecimal = BigDecimal.valueOf(precioUSD);
        if (precioUSD > 220) {
            precioUSDBigDecimal = precioUSDBigDecimal.multiply(BigDecimal.valueOf(1.21)); // Ajuste por precio mayor a 220 USD
        }

        // Agregar el costo de envío al precio en USD
        precioUSDBigDecimal = precioUSDBigDecimal.add(costoEnvioTotal);
        System.out.println("Precio en USD (con ajuste y envío): " + precioUSDBigDecimal);

        // Calcular el precio en soles
        BigDecimal precioSoles = precioUSDBigDecimal.multiply(tipoCambio);
        precioSoles = precioSoles.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Precio en Soles: " + precioSoles);

        // Calcular el precio final considerando la ganancia del 14%
        BigDecimal gananciaFactor = BigDecimal.valueOf(1 - 0.14);  // 1 - 0.14 = 0.86
        BigDecimal precioFinal = precioSoles.divide(gananciaFactor, 2, RoundingMode.HALF_UP);  // Dividir por 0.86 para agregar la ganancia
        precioFinal = precioFinal.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Precio Final: " + precioFinal);

        return precioFinal.doubleValue();
    }
}
