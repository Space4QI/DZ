package com.example.demo.repositories;

import com.example.demo.models.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.math.BigDecimal;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
        List<Bike> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
    }

