package com.TrucksAuctions.TruckEntityTests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.TrucksAuctions.models.Truck;
import com.TrucksAuctions.models.UserEntity;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@SpringBootTest
public class TruckEntityTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testNullUserEntity() {
        Truck truck = new Truck();
        truck.setOwner("A");
        truck.setManufacturer("Ford");
        truck.setDescription("A powerful truck");
        truck.setType("XL");
        truck.setEngineType("Diesel");
        truck.setMileage(120000);
        truck.setHp(400);
        truck.setRetarder("Yes");
        truck.setTransmission("Manual");
        truck.setAuxiliaryHeater("Yes");
        truck.setClimateControl("Yes");
        truck.setStationaryAC("Yes");
        truck.setYear(2022);
        truck.setColor("Red");
        truck.setPrice(75000);
        truck.setUser(null);

        Set<ConstraintViolation<Truck>> violations = validator.validate(truck);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidUserEntity() {
        Truck truck = new Truck();
        truck.setOwner("A");
        truck.setManufacturer("Ford");
        truck.setDescription("A powerful truck");
        truck.setType("L");
        truck.setEngineType("Diesel");
        truck.setMileage(120000);
        truck.setHp(400);
        truck.setRetarder("Yes");
        truck.setTransmission("Manual");
        truck.setAuxiliaryHeater("Yes");
        truck.setClimateControl("Yes");
        truck.setStationaryAC("Yes");
        truck.setYear(2022);
        truck.setColor("Red");
        truck.setPrice(75000);
        truck.setUser(new UserEntity());

        Set<ConstraintViolation<Truck>> violations = validator.validate(truck);
        assertTrue(violations.isEmpty());
    }
}
