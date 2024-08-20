package com.shopusa.server.dto;

import com.shopusa.server.entity.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoriaDTO {
    private String nombre;
    private String codigo;
    private Categoria categoriaId;
}
