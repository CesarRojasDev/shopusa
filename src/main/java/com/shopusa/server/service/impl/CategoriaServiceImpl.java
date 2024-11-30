package com.shopusa.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopusa.server.dto.CategoriaDTO;
import com.shopusa.server.entity.Categoria;
import com.shopusa.server.exeption.CategoriaNotFoundExeption;
import com.shopusa.server.mapper.CategoriaMapper;
import com.shopusa.server.repository.CategoriaRepository;
import com.shopusa.server.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    private CategoriaMapper categoriaMapper;

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(String id) {
        return findCategoriaById(id);
    }

    @Override
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.INSTANCE.toCategoria(categoriaDTO);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return categoriaMapper.INSTANCE.toCategoriaDTO(savedCategoria);
    }

    @Override
    public CategoriaDTO updateCategoria(String id,CategoriaDTO categoriaDTO) {
        Categoria existingCategoria = findCategoriaById(id);
        categoriaMapper.INSTANCE.updateCategoriaFromDto(categoriaDTO, existingCategoria);
        Categoria savedCategoria = categoriaRepository.save(existingCategoria);
        return categoriaMapper.INSTANCE.toCategoriaDTO(savedCategoria);
    }

    @Override
    public void deleteCategoria(String id) {
        Categoria categoria = findCategoriaById(id);
        categoriaRepository.delete(categoria);
    }

    private Categoria findCategoriaById(String id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFoundExeption("Categoria no encontrada con id " + id));
    }
}
