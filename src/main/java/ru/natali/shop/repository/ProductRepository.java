package ru.natali.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.natali.shop.model.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
