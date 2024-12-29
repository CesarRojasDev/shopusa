package com.shopusa.server.controller;

import com.shopusa.server.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/export/productos")
    public ResponseEntity<InputStreamResource> exportProductosToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportProductosToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=productos.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
    @GetMapping("/export/subcategorias")
    public ResponseEntity<InputStreamResource> exportSubCategoriasToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportSubCategoriasToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=subcategorias.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
    @GetMapping("/export/publicaciones")
    public ResponseEntity<InputStreamResource> exportPublicacionesToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportPublicacionesToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=publicaciones.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
    @GetMapping("/export/comisiones")
    public ResponseEntity<InputStreamResource> exportComisionesToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportComisionesToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=comisiones.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
    @GetMapping("/export/plataformas")
    public ResponseEntity<InputStreamResource> exportPlataformasToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportPlataformasToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=plataformas.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
    @GetMapping("/export/categorias")
    public ResponseEntity<InputStreamResource> exportCategoriasToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportCategoriasToExcel();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=categorias.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
