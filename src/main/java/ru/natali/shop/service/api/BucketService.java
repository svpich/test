package ru.natali.shop.service.api;

import ru.natali.shop.model.dto.ProductDto;

public interface BucketService {

    void addProductInBucket(ProductDto productDto);
    void deleteProductFromBucket(ProductDto productDto);
}
