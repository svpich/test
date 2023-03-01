package ru.natali.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.natali.shop.model.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
