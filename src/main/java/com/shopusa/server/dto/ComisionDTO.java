package com.shopusa.server.dto;

import lombok.Data;

@Data
public class ComisionDTO {
    private Double valor;
    private CategoriaDTO categoria;
    private PlataformaDTO plataforma;
}
