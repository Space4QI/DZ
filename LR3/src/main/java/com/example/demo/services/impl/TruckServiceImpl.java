package com.example.demo.services.impl;

import com.example.demo.models.Car;
import com.example.demo.models.Truck;
import com.example.demo.repositories.TruckRepository;
import com.example.demo.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TruckServiceImpl implements TruckService<Long> {

    @Autowired
    private TruckRepository truckRepository;

    @Override
    public void save(Truck truck) {
        truckRepository.save(truck);
    }

    @Override
    public List<Truck> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType) {
        return truckRepository.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
    }
}
