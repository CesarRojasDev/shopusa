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

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;
import com.shopusa.server.service.SubCategoriaService;

@RestController
@RequestMapping("/api/subcategorias")
public class SubCategoriaController {

    @Autowired
    private SubCategoriaService subCategoriaService;

    @Autowired
    private ExcelService excelService;

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
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> exportSubCategoriasToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportSubCategoriasToExcel();

        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String fileName = "SHOPUSA-SUBCATEGORIAS-" + formattedDate + ".xlsx";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
