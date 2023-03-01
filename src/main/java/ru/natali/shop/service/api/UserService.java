package ru.natali.shop.service.api;

import ru.natali.shop.model.entity.UserEntity;

public interface UserService {

    UserEntity getUserFromContext();
    UserEntity updateUser(UserEntity userEntity);
}
