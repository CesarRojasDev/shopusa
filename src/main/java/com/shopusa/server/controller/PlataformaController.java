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

import com.shopusa.server.dto.PlataformaDTO;
import com.shopusa.server.entity.Plataforma;
import com.shopusa.server.service.PlataformaService;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @Autowired
    private ExcelService excelService;

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

    @PutMapping("/{id}")
    public PlataformaDTO updatePlataforma(@PathVariable String id, @RequestBody PlataformaDTO plataformaDTO){
        return plataformaService.updatePlataforma(id,plataformaDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePlataforma(@PathVariable String id){
        plataformaService.deletePlataforma(id);
    }
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> exportPlataformasToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportPlataformasToExcel();

        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String fileName = "SHOPUSA-PLATAFORMAS-" + formattedDate + ".xlsx";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+ fileName);
        headers.add("X-File-Name",fileName);
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
