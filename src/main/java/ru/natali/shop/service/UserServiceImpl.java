package ru.natali.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.natali.shop.model.entity.UserEntity;
import ru.natali.shop.repository.UserRepository;
import ru.natali.shop.service.api.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserEntity getUserFromContext() {
        return repository.findById(1L).get();
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        try {
            log.info("Попытка обновления записи user в БД: {}", userEntity);
            userEntity = repository.save(userEntity);
            log.info("Обновление выполнено успешно: {}", userEntity);

            return userEntity;
        } catch (Exception ex) {
            log.error("Ошибка при обновлении", ex);
            // TODO обработать
            throw ex;
        }
    }
}
