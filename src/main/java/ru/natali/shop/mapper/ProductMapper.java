package ru.natali.shop.mapper;

import org.mapstruct.Mapper;
import ru.natali.shop.model.dto.ProductDto;
import ru.natali.shop.model.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductDto dto);
}
