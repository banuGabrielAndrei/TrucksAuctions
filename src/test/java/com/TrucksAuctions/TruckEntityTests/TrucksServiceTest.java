package com.TrucksAuctions.TruckEntityTests;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.TrucksAuctions.models.Truck;
import com.TrucksAuctions.repository.TrucksRepository;
import com.TrucksAuctions.services.TrucksServiceImpl;

import jakarta.transaction.Transactional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@Transactional
@SpringBootTest
public class TrucksServiceTest {

    @Mock
    private TrucksRepository trucksRepository;

    @InjectMocks
    private TrucksServiceImpl trucksService;

    @Test
    public void testFindTrucksByFilters() {
        List<Truck> trucks = List.of(new Truck());
        when(trucksRepository.findTrucksByFilters("Toyota",
                                 "Red", 2020)).thenReturn(trucks);

        List<Truck> result = trucksService.findTrucksByFilters("Toyota", 
                                                        "Red", 2020);
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(trucksRepository, times(1))
        .findTrucksByFilters("Toyota", "Red", 2020);
    }
}
