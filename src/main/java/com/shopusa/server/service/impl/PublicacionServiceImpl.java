package com.shopusa.server.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import com.shopusa.server.entity.Comision;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.exeption.ProductoNotFoundExeption;
import com.shopusa.server.repository.ComisionRepository;
import com.shopusa.server.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;
import com.shopusa.server.exeption.PublicacionNotFoundExeption;
import com.shopusa.server.mapper.PublicacionMapper;
import com.shopusa.server.repository.PublicacionRepository;
import com.shopusa.server.service.PublicacionService;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;
    private PublicacionMapper publicacionMapper;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ComisionRepository comisionRepository;

    @Override
    public List<Publicacion> getAllPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion getPublicacionById(String id) {
        return findPublicacionById(id);
    }

    @Override
    public PublicacionDTO createPublicacion(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = publicacionMapper.INSTANCE.toPublicacion(publicacionDTO);
        Publicacion savedpublicacion = publicacionRepository.save(publicacion);
        return publicacionMapper.INSTANCE.toPublicacionDTO(savedpublicacion);
    }

    @Override
    public PublicacionDTO updatePublicacion(String id, PublicacionDTO publicacionDTO) {
        Publicacion existingPubicacion = findPublicacionById(id);
        publicacionMapper.INSTANCE.updatePublicacionFromDto(publicacionDTO, existingPubicacion);
        Publicacion savedpublicacion = publicacionRepository.save(existingPubicacion);
        return publicacionMapper.INSTANCE.toPublicacionDTO(savedpublicacion);
    }

    @Override
    public void deletePublicacion(String id) {
        Publicacion publicacion = findPublicacionById(id);
        publicacionRepository.delete(publicacion);
    }

    @Override
    public Map<String, Object> calcularPrecio(String productoId, String plataformaId) {
        Producto producto = obtenerProductoPorId(productoId);
        String categoriaId = obtenerCategoriaDelProducto(producto);
        Comision comision = obtenerComisionPorPlataformaYCategoria(plataformaId, categoriaId);
        double precioFinal = calcularPrecioFinal(producto.getPrecioSoles(), comision.getValor());
        return construirRespuesta(productoId, precioFinal);
    }

    private Producto obtenerProductoPorId(String productoId) {
        return productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNotFoundExeption("Producto no encontrado con el ID: " + productoId));
    }

    private String obtenerCategoriaDelProducto(Producto producto) {
        if (producto.getSubCategoria() == null || producto.getSubCategoria().getCategoria() == null) {
            throw new RuntimeException("El producto no tiene una categoría válida");
        }
        return producto.getSubCategoria().getCategoria().getId();
    }

    private Comision obtenerComisionPorPlataformaYCategoria(String plataforma, String categoriaId) {
        return comisionRepository.findByPlataformaIdAndCategoriaId(plataforma, categoriaId)
                .orElseThrow(() -> new RuntimeException("Comisión no encontrada para la plataforma: "
                        + plataforma + " y categoría: " + categoriaId));
    }

    private double calcularPrecioFinal(double precioBase, double valorComision) {
        double precioFinal = precioBase + (precioBase * valorComision);
        return redondearPrecio(precioFinal);
    }

    private double redondearPrecio(double precio) {
        return BigDecimal.valueOf(precio)
                .setScale(0, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private Map<String, Object> construirRespuesta(String productoId, double precioFinal) {
        return Map.of(
                "producto", productoId,
                "precio", precioFinal
        );
    }

    private Publicacion findPublicacionById(String id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new PublicacionNotFoundExeption("Publicacion no encontrada con id " + id));
    }
}
