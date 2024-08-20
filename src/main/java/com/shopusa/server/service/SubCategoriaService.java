package com.shopusa.server.service;

import com.shopusa.server.entity.SubCategoria;

import java.util.List;
import java.util.Optional;

public interface SubCategoriaService {
    List<SubCategoria> getAllSubCategorias();
    Optional<SubCategoria> getSubCategoriaById(String id);
    SubCategoria createSubCategoria(SubCategoria subCategoria);
    SubCategoria updateSubCategoria(SubCategoria subCategoria);
    void deleteSubCategoria(String id);
}
