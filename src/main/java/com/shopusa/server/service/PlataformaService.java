package com.shopusa.server.service;


import com.shopusa.server.dto.PlataformaDTO;
import com.shopusa.server.entity.Plataforma;

import java.util.List;

public interface PlataformaService {
    List<Plataforma> getAllPlataformas();
    Plataforma getPlataformaById(String id);
    PlataformaDTO createPlataforma(PlataformaDTO plataformaDTO);
    PlataformaDTO updatePlataforma(String id, PlataformaDTO plataformaDTO);
    void deletePlataforma(String id);
}
