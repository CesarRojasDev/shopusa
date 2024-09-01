package com.shopusa.server.mapper;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    @Mapping(source = "subCategoria.nombre", target = "subCategoria.nombre")
    Producto toProducto(ProductoDTO productoDTO);
    @Mapping(source = "subCategoria.nombre", target = "subCategoria.nombre")
    ProductoDTO toProductoDTO(Producto producto);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductoFromDto(ProductoDTO productoDTO, @MappingTarget Producto producto);
}
