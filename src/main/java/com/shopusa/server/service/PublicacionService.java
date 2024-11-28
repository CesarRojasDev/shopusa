package com.shopusa.server.service;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;

import java.util.List;

public interface PublicacionService {
    List<Publicacion> getAllPublicaciones();
    Publicacion getPublicacionById(String id);
    PublicacionDTO createPublicacion(PublicacionDTO publicacionDTO);
    PublicacionDTO updatePublicacion(String id,PublicacionDTO publicacionDTO);
    void deletePublicacion(String id);
}
