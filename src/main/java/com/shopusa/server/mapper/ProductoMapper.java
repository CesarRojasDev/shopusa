package com.shopusa.server.mapper;

import com.shopusa.server.dto.ProductoDTO;
import com.shopusa.server.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);
    Producto toProducto(ProductoDTO productoDTO);
    ProductoDTO toProductoDTO(Producto producto);
}
