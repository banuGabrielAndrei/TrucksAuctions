package com.TrucksAuctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TrucksAuctions.models.Truck;

public interface TrucksRepository extends JpaRepository<Truck, Integer>{

}
