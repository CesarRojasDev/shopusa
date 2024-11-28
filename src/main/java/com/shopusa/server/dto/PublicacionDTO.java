package com.shopusa.server.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PublicacionDTO {
    private Date fechaPublicacion;
    private Double precio;
    private String skuPlataforma;
    private PlataformaDTO plataforma;
    private ProductoDTO producto;
    private UsuarioDTO usuario;
}
