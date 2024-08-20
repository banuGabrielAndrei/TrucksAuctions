package com.TrucksAuctions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.TrucksAuctions.models.Truck;
import com.TrucksAuctions.models.UserEntity;
import com.TrucksAuctions.repository.TrucksRepository;
import com.TrucksAuctions.repository.UsersRepository;
@Service
public class TrucksServiceImpl implements TrucksService{

    @Autowired
    TrucksRepository trucksRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void saveTruck(Truck truck) {
        Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
        String userEmail = authentication.getName();
        UserEntity user = usersRepository.findByEmail(userEmail);
        truck.setUser(user);
        trucksRepository.save(truck);
    }
}
