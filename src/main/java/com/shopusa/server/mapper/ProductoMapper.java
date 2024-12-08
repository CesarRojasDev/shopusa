package com.shopusa.server.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;

@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    @Mapping(source = "subCategoriaId", target = "subCategoria.id")
    Producto toProducto(ProductoDTO productoDTO);
    @Mapping(source = "subCategoria.id", target = "subCategoriaId")
    ProductoDTO toProductoDTO(Producto producto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductoFromDto(ProductoDTO productoDTO, @MappingTarget Producto producto);
}
