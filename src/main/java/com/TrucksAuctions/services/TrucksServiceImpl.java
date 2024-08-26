package com.TrucksAuctions.services;

import java.util.List;

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

    @Override
    public List<Truck> getAllTrucks() {
        List<Truck> allTrucks = trucksRepository.findAll();
        return allTrucks;
    }

    @Override
    public List<String> findTrucksByManufacturer() {
        return trucksRepository.findTrucksByManufacturer();
    }

    @Override
    public List<String> findTrucksByColor() {
        return trucksRepository.findTrucksByColor();
    }

    @Override
    public List<Integer> findTrucksByYear() {
        return trucksRepository.findTrucksByYear();
    }

    @Override
    public List<Truck> findTrucksByFilters(String manufacturer, String color,
                                          Integer year) {
        return trucksRepository.findTrucksByFilters(manufacturer, color, year);
    }
}
