package com.shopusa.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shopusa.server.dto.ImagenDTO;
import com.shopusa.server.entity.Imagen;
import com.shopusa.server.service.ImagenService;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public List<Imagen> getAllImagenes(){
        return imagenService.getAllImagenes();
    }

    @PostMapping
    public ImagenDTO createImagen(@RequestBody ImagenDTO imagenDTO){
        return imagenService.createImagen(imagenDTO);
    }
}
