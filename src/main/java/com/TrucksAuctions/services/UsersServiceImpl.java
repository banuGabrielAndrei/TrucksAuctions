package com.TrucksAuctions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.TrucksAuctions.models.UserEntity;
import com.TrucksAuctions.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserEntity user) {
        if (usersRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("This email is already used!");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        usersRepository.save(user);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
