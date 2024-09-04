package com.shopusa.server.service;

import com.shopusa.server.dto.PlataformaDTO;
import com.shopusa.server.entity.Categoria;
import com.shopusa.server.entity.Plataforma;
import com.shopusa.server.exeption.CategoriaNotFoundExeption;
import com.shopusa.server.exeption.PlataformaNotFoundExeption;
import com.shopusa.server.mapper.CategoriaMapper;
import com.shopusa.server.mapper.PlataformaMapper;
import com.shopusa.server.repository.CategoriaRepository;
import com.shopusa.server.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlataformaServiceImpl implements PlataformaService{
    @Autowired
    private PlataformaRepository plataformaRepository;
    private PlataformaMapper plataformaMapper;
    @Override
    public List<Plataforma> getAllPlataformas() {
        return plataformaRepository.findAll();
    }
    @Override
    public Plataforma getPlataformaById(String id) {
        return findPlataformaById(id);
    }
    @Override
    public PlataformaDTO createPlataforma(PlataformaDTO plataformaDTO) {
        Plataforma plataforma = plataformaMapper.INSTANCE.toPlataforma(plataformaDTO);
        Plataforma savedplataforma = plataformaRepository.save(plataforma);
        return plataformaMapper.INSTANCE.toPlataformaDTO(savedplataforma);
    }
    @Override
    public PlataformaDTO updatePlataforma(String id, PlataformaDTO plataformaDTO) {
        Plataforma existingPlataforma = findPlataformaById(id);
        plataformaMapper.INSTANCE.updatePlataformaFromDto(plataformaDTO, existingPlataforma);
        Plataforma savedPlataforma = plataformaRepository.save(existingPlataforma);
        return plataformaMapper.INSTANCE.toPlataformaDTO(savedPlataforma);
    }
    @Override
    public void deletePlataforma(String id) {
        Plataforma plataforma = findPlataformaById(id);
        plataformaRepository.delete(plataforma);
    }
    private Plataforma findPlataformaById(String id) {
        return plataformaRepository.findById(id)
                .orElseThrow(() -> new PlataformaNotFoundExeption("Plataforma no encontrada con id " + id));
    }
}
