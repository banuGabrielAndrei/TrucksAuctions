package com.TrucksAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrucksAuctions.models.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Integer>{

    UserEntity findByEmail(String email);

}
