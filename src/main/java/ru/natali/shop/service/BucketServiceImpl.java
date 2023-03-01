package ru.natali.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.natali.shop.mapper.ProductMapper;
import ru.natali.shop.model.dto.ProductDto;
import ru.natali.shop.service.api.BucketService;
import ru.natali.shop.service.api.UserService;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService {
    
    private final UserService userService;
    private final ProductMapper productMapper;

    @Override
    public void addProductInBucket(ProductDto productDto) {
        var user = userService.getUserFromContext();
        user.getBucket().getProductList().add(productMapper.toEntity(productDto));
        userService.updateUser(user);
    }

    @Override
    public void deleteProductFromBucket(ProductDto productDto) {
        var user = userService.getUserFromContext();
        user.getBucket().getProductList().add(productMapper.toEntity(productDto));
        userService.updateUser(user);
    }
}
