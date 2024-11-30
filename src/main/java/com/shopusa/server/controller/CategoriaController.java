package com.shopusa.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shopusa.server.dto.CategoriaDTO;
import com.shopusa.server.entity.Categoria;
import com.shopusa.server.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria>getCategorias(){
        return  categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Categoria getCategoria(@PathVariable String id){
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.createCategoria(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO updateCategoria(@PathVariable String id, @RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.updateCategoria(id,categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable String id){
        categoriaService.deleteCategoria(id);
    }
}
