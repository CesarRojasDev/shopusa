package com.shopusa.server.service;

import java.util.List;
import java.util.Map;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;

public interface PublicacionService {
    List<Publicacion> getAllPublicaciones();
    Publicacion getPublicacionById(String id);
    PublicacionDTO createPublicacion(PublicacionDTO publicacionDTO);
    PublicacionDTO updatePublicacion(String id,PublicacionDTO publicacionDTO);
    void deletePublicacion(String id);
    Map<String, Object> calcularPrecio(String productoId, String plataformaId);
}
