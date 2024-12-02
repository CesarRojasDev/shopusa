package com.shopusa.server.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.CategoriaDTO;
import com.shopusa.server.entity.Categoria;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO toCategoriaDTO(Categoria categoria);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCategoriaFromDto(CategoriaDTO categoriaDTO, @MappingTarget Categoria categoria);
}
