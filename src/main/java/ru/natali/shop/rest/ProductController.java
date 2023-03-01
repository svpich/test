package ru.natali.shop.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.natali.shop.model.dto.ProductDto;
import ru.natali.shop.service.api.ProductService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDto product) {
        log.info("Запрос POST /product/add {}", product);
        productService.addProduct(product);
    }
}
