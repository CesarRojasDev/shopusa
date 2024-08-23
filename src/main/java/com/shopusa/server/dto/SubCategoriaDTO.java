package com.shopusa.server.dto;

import com.shopusa.server.entity.Categoria;
import lombok.Data;


@Data
public class SubCategoriaDTO {
    private String id;
    private String nombre;
    private String codigo;
    private Categoria categoriaId;
}
