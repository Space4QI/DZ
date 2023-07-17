package com.example.demo.services;

import com.example.demo.models.Plane;

import java.util.List;
import java.math.BigDecimal;

public interface PlaneService<ID> {
    void save(Plane plane);

    List<Plane> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
}
