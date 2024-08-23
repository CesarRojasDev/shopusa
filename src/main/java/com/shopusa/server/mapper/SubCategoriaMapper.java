package com.shopusa.server.mapper;

import com.shopusa.server.dto.SubCategoriaDTO;
import com.shopusa.server.entity.SubCategoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubCategoriaMapper {
    SubCategoriaMapper INSTANCE = Mappers.getMapper(SubCategoriaMapper.class);

    SubCategoria toSubCategoria(SubCategoriaDTO subCategoriaDTO);
    SubCategoriaDTO toSubCategoriaDTO(SubCategoria subCategoria);
}
