package com.shopusa.server.service.impl;

import com.shopusa.server.dto.ImagenDTO;
import com.shopusa.server.entity.Comision;
import com.shopusa.server.entity.Imagen;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.mapper.ImagenMapper;
import com.shopusa.server.repository.ImagenRepository;
import com.shopusa.server.repository.ProductoRepository;
import com.shopusa.server.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImagenServiceImpl implements ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;
    private ImagenMapper imagenMapper;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Imagen> getAllImagenes() {
        return imagenRepository.findAll();
    }

    @Override
    public List<Imagen> createImagen(ImagenDTO imagenDTO) {
        // Obtener el producto asociado usando el productoId
        Producto producto = productoRepository.findById(imagenDTO.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        // Crear una lista de objetos Imagen y asignarles el producto
        List<Imagen> imagenes = imagenDTO.getUrls().stream()
                .map(url -> {
                    Imagen imagen = new Imagen();
                    imagen.setUrl(url);
                    imagen.setProducto(producto);  // Asignar el producto a la imagen
                    return imagen;
                })
                .collect(Collectors.toList());

        // Guardar las imágenes en la base de datos
        return imagenRepository.saveAll(imagenes);
    }
}