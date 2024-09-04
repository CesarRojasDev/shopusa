package com.shopusa.server.controller;

import com.shopusa.server.dto.PlataformaDTO;
import com.shopusa.server.entity.Plataforma;
import com.shopusa.server.service.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping
    public List<Plataforma> getAllPlataformas(){
        return plataformaService.getAllPlataformas();
    }
    @GetMapping("/{id}")
    public Plataforma getPlataforma(@PathVariable String id){
        return plataformaService.getPlataformaById(id);
    }
    @PostMapping
    public PlataformaDTO createPlataforma(@RequestBody PlataformaDTO plataformaDTO){
        return plataformaService.createPlataforma(plataformaDTO);
    }
    @DeleteMapping("/{id}")
    public void deletePlataforma(@PathVariable String id){
        plataformaService.deletePlataforma(id);
    }
    @PutMapping("/{id}")
    public PlataformaDTO updatePlataforma(@PathVariable String id, @RequestBody PlataformaDTO plataformaDTO){
        return plataformaService.updatePlataforma(id,plataformaDTO);
    }
}
