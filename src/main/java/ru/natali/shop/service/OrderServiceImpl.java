package ru.natali.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.natali.shop.mapper.OrderMapper;
import ru.natali.shop.model.entity.OrderDetailsEntity;
import ru.natali.shop.model.entity.OrderEntity;
import ru.natali.shop.model.entity.ProductEntity;
import ru.natali.shop.repository.OrderDetailsRepository;
import ru.natali.shop.repository.OrderRepository;
import ru.natali.shop.service.api.OrderService;
import ru.natali.shop.service.api.UserService;
import ru.natali.shop.util.OrderStatus;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final UserService userService;
    private final OrderMapper orderMapper;

    @Override
    public void createOrder() {
        OrderEntity order = new OrderEntity();

        var user = userService.getUserFromContext();

        var bucket = user.getBucket();
        var orderDetailsEntityList = orderMapper.productEntityListToOrderDetailList(bucket.getProductList());

        order.setDetailsList(orderDetailsEntityList);
        order.setStatus(OrderStatus.NEW);
        order.setUser(user);
        order.setTotalPrice(getTotalOrderPrice(orderDetailsEntityList));

        saveOrder(order);
    }

    @Override
    public OrderEntity getOrder() {
        return orderRepository.findById(2L).get();
    }

    private OrderEntity saveOrder(OrderEntity orderEntity) {
        try {
            log.info("Попытка сохраниния записи order в БД: {}", orderEntity);
            orderEntity = orderRepository.save(orderEntity);
            log.info("Сохранение выполнено успешно: {}", orderEntity);

            return orderEntity;
        } catch (Exception ex) {
            log.error("Ошибка при сохранении", ex);
            // TODO обработать
            throw ex;
        }
    }

    private BigDecimal getTotalOrderPrice(List<OrderDetailsEntity> orderDetailsEntityList) {
        log.info("Подсчет общей стоимости для заказа ");
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (OrderDetailsEntity orderEntity : orderDetailsEntityList) {
            totalPrice = totalPrice.add(orderEntity.getPrice());
        }
        return totalPrice;
    }
}
