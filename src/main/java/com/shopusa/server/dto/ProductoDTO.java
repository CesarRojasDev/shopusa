package com.shopusa.server.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductoDTO {
    private String id;
    private String nombre;
    private Double precioUSD;
    private Double precioSoles;
    private String sku;
    private Integer stock = 4;
    private String marca;
    private String modelo;
    private String color;
    private String descripcion;
    private String caracteristica;
    private String link;
    private String subCategoriaId;
}
