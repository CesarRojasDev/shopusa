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

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;
import com.shopusa.server.service.ComisionService;

@RestController
@RequestMapping("/api/comisiones")
public class ComisionController {

    @Autowired
    private ComisionService comisionService;

    @Autowired
    private ExcelService excelService;

    @GetMapping
    public List<Comision> getComisiones(){
        return comisionService.getAllComisiones();
    }

    @GetMapping("/{id}")
    public Comision getComision(@PathVariable String id){
        return comisionService.getComisionById(id);
    }

    @PostMapping
    public ComisionDTO createComision(@RequestBody ComisionDTO comisionDTO){
        return comisionService.createComision(comisionDTO);
    }

    @PutMapping("/{id}")
    public ComisionDTO updateComision(@PathVariable String id, @RequestBody ComisionDTO comisionDTO){
        return comisionService.updateComision(id,comisionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteComision(@PathVariable String id){
        comisionService.deleteComision(id);
    }

    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> exportComisionesToExcel() throws IOException {
        ByteArrayInputStream in = excelService.exportComisionesToExcel();
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        String fileName = "SHOPUSA-COMISIONES-" + formattedDate + ".xlsx";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename="+fileName);

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }
}
