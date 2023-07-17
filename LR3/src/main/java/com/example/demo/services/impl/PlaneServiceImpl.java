package com.example.demo.services.impl;

import com.example.demo.models.Car;
import com.example.demo.models.Plane;
import com.example.demo.repositories.PlaneRepository;
import com.example.demo.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService<Long> {

    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public void save(Plane plane) {
        planeRepository.save(plane);
    }

    @Override
    public List<Plane> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType) {
        return planeRepository.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
    }
}
