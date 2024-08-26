package com.TrucksAuctions.services;

import java.util.List;

import com.TrucksAuctions.models.Truck;

public interface TrucksService {

    void saveTruck(Truck truck);

    List<Truck> getAllTrucks();

    List<String> findTrucksByManufacturer();

    List<String> findTrucksByColor();

    List<Integer> findTrucksByYear();

    List<Truck> findTrucksByFilters(String manufacturer, String color,
                                    Integer year);
}
