package ru.natali.shop.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private Long id;

    private BigDecimal price;

    private String title;
}
