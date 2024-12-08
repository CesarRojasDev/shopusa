package com.shopusa.server.service.impl;

import com.shopusa.server.dto.ImagenDTO;
import com.shopusa.server.entity.Comision;
import com.shopusa.server.entity.Imagen;
import com.shopusa.server.mapper.ImagenMapper;
import com.shopusa.server.repository.ImagenRepository;
import com.shopusa.server.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenServiceImpl implements ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;
    private ImagenMapper imagenMapper;

    @Override
    public List<Imagen> getAllImagenes() {
        return imagenRepository.findAll();
    }

    @Override
    public ImagenDTO createImagen(ImagenDTO imagenDTO) {
        Imagen imagen = imagenMapper.INSTANCE.toImagen(imagenDTO);
        Imagen savedimagen = imagenRepository.save(imagen);
        return imagenMapper.INSTANCE.toImagenDTO(savedimagen);
    }
}
