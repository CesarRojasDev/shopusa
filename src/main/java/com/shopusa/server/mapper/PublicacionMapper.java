package com.shopusa.server.mapper;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublicacionMapper {
    PublicacionMapper INSTANCE = Mappers.getMapper(PublicacionMapper.class);

    @Mapping(source = "plataforma.nombre", target = "plataforma.nombre")
    @Mapping(source = "producto.nombre", target = "producto.nombre")
    @Mapping(source = "usuario.username", target = "usuario.username")
    Publicacion toPublicacion(PublicacionDTO publicacionDTO);

    @Mapping(source = "plataforma.nombre", target = "plataforma.nombre")
    @Mapping(source = "producto.nombre", target = "producto.nombre")
    @Mapping(source = "usuario.username", target = "usuario.username")
    PublicacionDTO toPublicacionDTO(Publicacion publicacion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePublicacionFromDto(PublicacionDTO publicacionDTO, @MappingTarget Publicacion publicacion);
}
