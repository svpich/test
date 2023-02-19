package ru.nataliShop.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nataliShop.model.entity.Client;

public interface UserRepository extends JpaRepository<Client, Long> {
}
