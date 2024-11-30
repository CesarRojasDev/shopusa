package com.shopusa.server.service;

import java.util.List;

import com.shopusa.server.dto.PlataformaDTO;
import com.shopusa.server.entity.Plataforma;

public interface PlataformaService {
    List<Plataforma> getAllPlataformas();
    Plataforma getPlataformaById(String id);
    PlataformaDTO createPlataforma(PlataformaDTO plataformaDTO);
    PlataformaDTO updatePlataforma(String id, PlataformaDTO plataformaDTO);
    void deletePlataforma(String id);
}
