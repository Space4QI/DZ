package com.example.demo.repositories;

import com.example.demo.models.Bike;
import com.example.demo.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
    List<Plane> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
}
