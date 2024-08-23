package com.shopusa.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CategoriaDTO {
    private String id;
    private String nombre;
    private double alto;
    private double ancho;
    private double largo;
    private String garantia;
    private double pesoGramos;
    private  double comision;
}
