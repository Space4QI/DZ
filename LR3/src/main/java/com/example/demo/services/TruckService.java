package com.example.demo.services;

import com.example.demo.models.Truck;

import java.util.List;
import java.math.BigDecimal;

public interface TruckService<ID> {
    void save(Truck truck);

    List<Truck> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
}
