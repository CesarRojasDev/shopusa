package com.shopusa.server.dto;

import java.util.Date;

import lombok.Data;

@Data
public class PublicacionDTO {
    private Date fechaPublicacion;
    private Double precio;
    private String skuPlataforma;
    private String plataformaId;
    private String sku;
    private String usuarioId;
}
