package com.shopusa.server.service;

import java.util.List;

import com.shopusa.server.dto.ImagenDTO;
import com.shopusa.server.entity.Imagen;

public interface ImagenService {
    List<Imagen> getAllImagenes();
    ImagenDTO createImagen(ImagenDTO imagenDTO);
}
