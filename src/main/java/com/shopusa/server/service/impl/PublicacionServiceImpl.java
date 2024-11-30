package com.shopusa.server.service.impl;

import java.util.List;

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
    private Publicacion findPublicacionById(String id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new PublicacionNotFoundExeption("Publicacion no encontrada con id " + id));
    }
}
