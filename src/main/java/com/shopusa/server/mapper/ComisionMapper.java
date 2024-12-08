package com.shopusa.server.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;

@Mapper
public interface ComisionMapper {

    ComisionMapper INSTANCE = Mappers.getMapper(ComisionMapper.class);

    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(source = "plataformaId", target = "plataforma.id")
    Comision toComision(ComisionDTO comisionDTO);
    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "plataforma.id", target = "plataformaId")
    ComisionDTO toComisionDTO(Comision comision);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateComisionFromDto(ComisionDTO comisionDTO, @MappingTarget Comision comision);
}
