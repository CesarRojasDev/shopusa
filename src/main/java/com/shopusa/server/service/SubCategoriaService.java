package com.shopusa.server.service;

import java.util.List;

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;

public interface SubCategoriaService {
    List<SubCategoria> getAllSubCategorias();
    SubCategoria getSubCategoriaById(String id);
    SubCategoriaDTO createSubCategoria(SubCategoriaDTO subCategoriaDTO);
    SubCategoriaDTO updateSubCategoria(String id, SubCategoriaDTO subCategoriaDTO);
    void deleteSubCategoria(String id);
}
