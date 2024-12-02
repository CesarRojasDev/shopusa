package com.shopusa.server.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.PlataformaDTO;
import com.shopusa.server.entity.Plataforma;

@Mapper
public interface PlataformaMapper {

    PlataformaMapper INSTANCE = Mappers.getMapper(PlataformaMapper.class);

    Plataforma toPlataforma(PlataformaDTO plataformaDTO);
    PlataformaDTO toPlataformaDTO(Plataforma plataforma);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePlataformaFromDto(PlataformaDTO plataformaDTO, @MappingTarget Plataforma plataforma);
}
