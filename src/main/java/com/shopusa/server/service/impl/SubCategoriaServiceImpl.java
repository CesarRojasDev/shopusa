package com.shopusa.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;
import com.shopusa.server.exeption.SubCategoriaNotFoundExeption;
import com.shopusa.server.mapper.SubCategoriaMapper;
import com.shopusa.server.repository.SubCategoriaRepository;
import com.shopusa.server.service.SubCategoriaService;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService {

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;
    private SubCategoriaMapper subCategoriaMapper;

    @Override
    public List<SubCategoria> getAllSubCategorias() {
        return subCategoriaRepository.findAll();
    }

    @Override
    public SubCategoria getSubCategoriaById(String id) {
        return findSubCategoriaById(id);
    }

    @Override
    public SubCategoriaDTO createSubCategoria(SubCategoriaDTO subCategoriaDTO) {
        SubCategoria subcategoria = subCategoriaMapper.INSTANCE.toSubCategoria(subCategoriaDTO);
        SubCategoria savedsubCategoria = subCategoriaRepository.save(subcategoria);
        return subCategoriaMapper.INSTANCE.toSubCategoriaDTO(savedsubCategoria);
    }

    @Override
    public SubCategoriaDTO updateSubCategoria(String id, SubCategoriaDTO subCategoriaDTO) {
        SubCategoria existingSubCategoria = findSubCategoriaById(id);
        subCategoriaMapper.INSTANCE.updateSubCategoriaFromDto(subCategoriaDTO, existingSubCategoria);
        SubCategoria savedSubCategoria = subCategoriaRepository.save(existingSubCategoria);
        return subCategoriaMapper.INSTANCE.toSubCategoriaDTO(savedSubCategoria);
    }

    @Override
    public void deleteSubCategoria(String id) {
        SubCategoria subcategoria = findSubCategoriaById(id);
        subCategoriaRepository.delete(subcategoria);
    }

    private SubCategoria findSubCategoriaById(String id) {
        return subCategoriaRepository.findById(id)
                .orElseThrow(() -> new SubCategoriaNotFoundExeption("SubCategoria no encontrada con id " + id));
    }
}
