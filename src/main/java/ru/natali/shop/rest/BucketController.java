package ru.natali.shop.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.natali.shop.model.dto.ProductDto;
import ru.natali.shop.service.api.BucketService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/bucket")
public class BucketController {

    private final BucketService bucketService;

    @PostMapping(value = "/addProduct")
    public void addProductInBucket(@RequestBody ProductDto product) {
        log.info("Запрос /addProduct: {}", product);
        bucketService.addProductInBucket(product);
    }

    @DeleteMapping(value = "/deleteProduct")
    public void deleteProductFromBucket(@RequestBody ProductDto product) {
        log.info("Запрос /bucket/deleteProduct: {}", product);
        bucketService.deleteProductFromBucket(product);
    }
}
