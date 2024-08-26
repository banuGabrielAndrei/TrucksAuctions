package com.TrucksAuctions.TruckEntityTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TrucksAuctions.repository.TrucksRepository;

import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
public class TruckRepositoryTest {

    @Autowired
    TrucksRepository trucksRepository;

    @Test
    public void findTrucksByManufacturerTest() {
        List<String> manufacturers = trucksRepository.findTrucksByManufacturer();
        assertNotNull(manufacturers);
        assertFalse(manufacturers.isEmpty());
    }

    @Test
    public void findTrucksByYearTest() {
        List<Integer> years = trucksRepository.findTrucksByYear();
        assertNotNull(years);
        assertFalse(years.isEmpty());
    }
}
