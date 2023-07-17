package com.example.demo.services;

import com.example.demo.models.Bike;

import java.util.Optional;
import java.math.BigDecimal;
import java.util.List;

public interface BikeService<ID> {
    void save(Bike bike);
    void delete(ID id);
    Optional<Bike> find(ID id);

    List<Bike> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
}
