package ru.natali.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.natali.shop.model.entity.OrderDetailsEntity;
import ru.natali.shop.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "product", source = "product")
    @Mapping(target = "price", source = "price")
    OrderDetailsEntity productToOrderDetailsEntity(ProductEntity product);

    default List<OrderDetailsEntity> productEntityListToOrderDetailList(List<ProductEntity> productEntityList) {
        List<OrderDetailsEntity> resultList = new ArrayList<>();

        productEntityList.forEach(product -> resultList.add(productToOrderDetailsEntity(product)));
        return resultList;
    }
}
