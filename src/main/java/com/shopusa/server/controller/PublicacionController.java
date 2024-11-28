package com.shopusa.server.controller;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;
import com.shopusa.server.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping
    public List<Publicacion> getAllPublicaciones(){return  publicacionService.getAllPublicaciones();}
    @GetMapping("/{id}")
    public Publicacion getPublicacion(@PathVariable String id){
        return publicacionService.getPublicacionById(id);
    }
    @PostMapping
    public PublicacionDTO createPublicacion(@RequestBody PublicacionDTO publicacionDTO){
        return  publicacionService.createPublicacion(publicacionDTO);
    }
    @PutMapping("/{id}")
    public PublicacionDTO updatePublicacion(@PathVariable String id, @RequestBody PublicacionDTO publicacionDTO){
        return publicacionService.updatePublicacion(id, publicacionDTO);
    }
    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable String id){
        publicacionService.deletePublicacion(id);
    }
}
