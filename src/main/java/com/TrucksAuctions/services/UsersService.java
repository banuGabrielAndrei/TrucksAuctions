package com.TrucksAuctions.services;

import com.TrucksAuctions.models.UserEntity;

public interface UsersService {

    void saveUser(UserEntity user);

    UserEntity findByEmail(String email);

}
