package ru.natali.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.natali.shop.model.entity.BucketEntity;

public interface BucketRepository extends JpaRepository<BucketEntity, Long> {
}
