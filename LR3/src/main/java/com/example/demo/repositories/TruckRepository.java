package com.example.demo.repositories;

import com.example.demo.models.Bike;
import com.example.demo.models.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {
    List<Truck> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
}
