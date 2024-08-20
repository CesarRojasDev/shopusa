package com.shopusa.server.controller;

import com.shopusa.server.entity.Categoria;
import com.shopusa.server.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria>getCategorias(){
        return  categoriaService.getAllCategorias();
    }
    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria){
        return categoriaService.createCategoria(categoria);
    }
}
