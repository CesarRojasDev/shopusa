package com.shopusa.server.service;

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;

import java.util.List;


public interface SubCategoriaService {
    List<SubCategoria> getAllSubCategorias();
    SubCategoria getSubCategoriaById(String id);
    SubCategoriaDTO createSubCategoria(SubCategoriaDTO subCategoriaDTO);
    SubCategoriaDTO updateSubCategoria(String id, SubCategoriaDTO subCategoriaDTO);
    void deleteSubCategoria(String id);
}
