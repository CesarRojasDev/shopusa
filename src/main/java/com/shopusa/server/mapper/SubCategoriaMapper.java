package com.shopusa.server.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;

@Mapper
public interface SubCategoriaMapper {

    SubCategoriaMapper INSTANCE = Mappers.getMapper(SubCategoriaMapper.class);

    @Mapping(source = "categoria.nombre", target = "categoria.nombre")
    SubCategoria toSubCategoria(SubCategoriaDTO subCategoriaDTO);
    @Mapping(source = "categoria.nombre", target = "categoria.nombre")
    SubCategoriaDTO toSubCategoriaDTO(SubCategoria subCategoria);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSubCategoriaFromDto(SubCategoriaDTO subCategoriaDTO, @MappingTarget SubCategoria subCategoria);
}
