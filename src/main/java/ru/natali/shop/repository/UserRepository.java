package ru.natali.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.natali.shop.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
