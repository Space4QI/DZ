package com.example.demo.services.impl;


import com.example.demo.models.Bike;
import com.example.demo.models.Car;
import com.example.demo.repositories.BikeRepository;
import com.example.demo.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService<Long> {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public void save(Bike bike) {
        bikeRepository.save(bike);
    }


    @Override
    public void delete(Long id) {
        bikeRepository.deleteById(id);
    }


    @Override
    public Optional<Bike> find(Long id) {
        return bikeRepository.findById(id);
    }

    @Override
    public List<Bike> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType) {
        return bikeRepository.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
    }
}
