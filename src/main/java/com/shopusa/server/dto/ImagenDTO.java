package com.shopusa.server.dto;

import lombok.Data;

import java.util.List;

@Data
public class ImagenDTO {
    private List<String> urls;
    private String productoId;
}
