package com.shopusa.server.mapper;

import com.shopusa.server.dto.ComisionDTO;
import com.shopusa.server.entity.Comision;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComisionMapper {
    ComisionMapper INSTANCE = Mappers.getMapper(ComisionMapper.class);

    @Mapping(source = "categoria.nombre", target = "categoria.nombre")
    @Mapping(source = "plataforma.nombre", target = "plataforma.nombre")
    Comision toComision(ComisionDTO comisionDTO);
    @Mapping(source = "categoria.nombre", target = "categoria.nombre")
    @Mapping(source = "plataforma.nombre", target = "plataforma.nombre")
    ComisionDTO toComisionDTO(Comision comision);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateComisionFromDto(ComisionDTO comisionDTO, @MappingTarget Comision comision);
}
