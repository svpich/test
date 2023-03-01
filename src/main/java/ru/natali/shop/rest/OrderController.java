package ru.natali.shop.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.natali.shop.model.entity.OrderEntity;
import ru.natali.shop.service.api.OrderService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/create")
    public void createOrder() {
        log.info("Запрос POST /order/create");
        orderService.createOrder();
    }

    @GetMapping(value = "/get")
    public OrderEntity getOrder() {
        log.info("Запрос GET /order/get");
        return orderService.getOrder();
    }
}
