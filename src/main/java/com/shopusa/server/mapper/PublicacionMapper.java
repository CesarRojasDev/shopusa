package com.shopusa.server.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;

@Mapper
public interface PublicacionMapper {

    PublicacionMapper INSTANCE = Mappers.getMapper(PublicacionMapper.class);

    @Mapping(source = "plataformaId", target = "plataforma.id")
    @Mapping(source = "productoId", target = "producto.id")
    @Mapping(source = "usuarioId", target = "usuario.id")
    Publicacion toPublicacion(PublicacionDTO publicacionDTO);
    @Mapping(source = "plataforma.id", target = "plataformaId")
    @Mapping(source = "producto.id", target = "productoId")
    @Mapping(source = "usuario.id", target = "usuarioId")
    PublicacionDTO toPublicacionDTO(Publicacion publicacion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePublicacionFromDto(PublicacionDTO publicacionDTO, @MappingTarget Publicacion publicacion);
}
