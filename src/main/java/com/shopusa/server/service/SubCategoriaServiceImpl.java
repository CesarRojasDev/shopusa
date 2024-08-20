package com.shopusa.server.service;

import com.shopusa.server.entity.SubCategoria;
import com.shopusa.server.repository.SubCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoriaServiceImpl implements  SubCategoriaService{

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;
    @Override
    public List<SubCategoria> getAllSubCategorias() {return subCategoriaRepository.findAll();}

    @Override
    public Optional<SubCategoria> getSubCategoriaById(String id) {
        return Optional.empty();
    }

    @Override
    public SubCategoria createSubCategoria(SubCategoria subCategoria) {
        return  subCategoriaRepository.save(subCategoria);
    }

    @Override
    public SubCategoria updateSubCategoria(SubCategoria subCategoria) {
        return null;
    }

    @Override
    public void deleteSubCategoria(String id) {

    }
}
