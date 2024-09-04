package com.shopusa.server.controller;

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;
import com.shopusa.server.service.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comisiones")
public class ComisionController {
    @Autowired
    private ComisionService comisionService;

    @GetMapping
    public List<Comision> getComisiones(){return comisionService.getAllComisiones();}

    @GetMapping("/{id}")
    public Comision getComision(@PathVariable String id){
        return comisionService.getComisionById(id);
    }
    @PostMapping
    public ComisionDTO createComision(@RequestBody ComisionDTO comisionDTO){
        return comisionService.createComision(comisionDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteComision(@PathVariable String id){
        comisionService.deleteComision(id);
    }
    @PutMapping("/{id}")
    public ComisionDTO updateComision(@PathVariable String id, @RequestBody ComisionDTO comisionDTO){
        return comisionService.updateComision(id,comisionDTO);
    }
}
