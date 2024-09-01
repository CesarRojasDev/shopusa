package com.shopusa.server.service;

import com.shopusa.server.dto.CategoriaDTO;
import com.shopusa.server.entity.Categoria;


import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> getAllCategorias();
    Categoria getCategoriaById(String id);
    CategoriaDTO createCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO updateCategoria(String id, CategoriaDTO categoriaDTO);
    void deleteCategoria(String id);
}
