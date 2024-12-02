package com.shopusa.server.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.PublicacionDTO;
import com.shopusa.server.entity.Publicacion;

@Mapper
public interface PublicacionMapper {

    PublicacionMapper INSTANCE = Mappers.getMapper(PublicacionMapper.class);

    Publicacion toPublicacion(PublicacionDTO publicacionDTO);
    PublicacionDTO toPublicacionDTO(Publicacion publicacion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePublicacionFromDto(PublicacionDTO publicacionDTO, @MappingTarget Publicacion publicacion);
}
