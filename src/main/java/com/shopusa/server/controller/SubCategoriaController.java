package com.shopusa.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;
import com.shopusa.server.service.SubCategoriaService;

@RestController
@RequestMapping("/api/subcategorias")
public class SubCategoriaController {

    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping
    public List<SubCategoria> getAllSubCategorias(){
        return  subCategoriaService.getAllSubCategorias();
    }

    @GetMapping("/{id}")
    public SubCategoria getSubCategoria(@PathVariable String id){
        return subCategoriaService.getSubCategoriaById(id);
    }

    @PostMapping
    public SubCategoriaDTO createSubCategoria(@RequestBody SubCategoriaDTO subCategoriaDTO){
        return  subCategoriaService.createSubCategoria(subCategoriaDTO);
    }

    @PutMapping("/{id}")
    public SubCategoriaDTO updateSubCategoria(@PathVariable String id, @RequestBody SubCategoriaDTO subCategoriaDTO){
        return subCategoriaService.updateSubCategoria(id, subCategoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSubCategoria(@PathVariable String id){
        subCategoriaService.deleteSubCategoria(id);
    }
}
