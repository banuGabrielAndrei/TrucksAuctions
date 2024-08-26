package com.TrucksAuctions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TrucksAuctions.models.Truck;

public interface TrucksRepository extends JpaRepository<Truck, Integer>{

    @Query("SELECT DISTINCT truck.manufacturer FROM Truck truck")
    List<String> findTrucksByManufacturer();

    @Query("SELECT DISTINCT truck.color FROM Truck truck")
    List<String> findTrucksByColor();

    @Query("SELECT DISTINCT truck.year FROM Truck truck")
    List<Integer> findTrucksByYear();

    @Query("SELECT truck FROM Truck truck WHERE"
    + "(:manufacturer IS NULL OR truck.manufacturer = :manufacturer) AND "
    + "(:color IS NULL OR truck.color = :color) AND "
    + "(:year IS NULL OR truck.year = :year)")
    List<Truck> findTrucksByFilters(@Param("manufacturer") String manufacturer,
                                    @Param("color") String color,
                                    @Param("year") Integer year);
}
