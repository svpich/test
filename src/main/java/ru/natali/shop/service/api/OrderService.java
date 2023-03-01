package ru.natali.shop.service.api;

import ru.natali.shop.model.entity.OrderEntity;

public interface OrderService {

    void createOrder();

    OrderEntity getOrder();
}
