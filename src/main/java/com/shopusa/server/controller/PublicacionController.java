package com.shopusa.server.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import com.shopusa.server.entity.Comision;
import com.shopusa.server.entity.Producto;
import com.shopusa.server.repository.ComisionRepository;
import com.shopusa.server.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;
import com.shopusa.server.service.PublicacionService;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ComisionRepository comisionRepository;
    @GetMapping
    public List<Publicacion> getAllPublicaciones(){
        return  publicacionService.getAllPublicaciones();
    }

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
    @GetMapping("/calcular-precio")
    public ResponseEntity<?> calcularPrecio(@RequestParam String productoId, @RequestParam String plataformaId) {
        Map<String, Object> resultado = publicacionService.calcularPrecio(productoId, plataformaId);
        return ResponseEntity.ok(resultado);
    }
}
