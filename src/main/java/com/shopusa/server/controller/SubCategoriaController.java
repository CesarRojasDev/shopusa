package com.shopusa.server.controller;

import com.shopusa.server.entity.SubCategoria;
import com.shopusa.server.service.SubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subcategorias")
public class SubCategoriaController {

    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping
    public List<SubCategoria> getAllSubCategorias(){return  subCategoriaService.getAllSubCategorias();}
    @GetMapping("/{id}")
    public Optional<SubCategoria> getSubCategoria(@PathVariable String id){
        return subCategoriaService.getSubCategoriaById(id);
    }

    @PostMapping
    public SubCategoria createSubCategoria(@RequestBody SubCategoria subCategoria){
        return  subCategoriaService.createSubCategoria(subCategoria);
    }

}
