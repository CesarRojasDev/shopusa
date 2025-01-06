package com.shopusa.server.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.shopusa.server.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shopusa.server.dto.CategoriaDTO;
import com.shopusa.server.entity.Categoria;
import com.shopusa.server.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ExcelService excelService;

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

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> exportCategoriasToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportCategoriasToExcel();

        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String fileName = "SHOPUSA-CATEGORIAS-" + formattedDate + ".xlsx";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
