package com.shopusa.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.ImagenDTO;
import com.shopusa.server.entity.Imagen;

@Mapper
public interface ImagenMapper {

    ImagenMapper INSTANCE = Mappers.getMapper(ImagenMapper.class);
    @Mapping(source = "productoId", target = "producto.id")
    Imagen toImagen(ImagenDTO imagenDTO);
    @Mapping(source = "producto.id", target = "productoId")
    ImagenDTO toImagenDTO(Imagen imagen);

}
