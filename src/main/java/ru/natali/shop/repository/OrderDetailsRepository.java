package ru.natali.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.natali.shop.model.entity.OrderDetailsEntity;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
}
