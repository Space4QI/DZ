package com.example.demo.services.impl;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import com.example.demo.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@Service
public class CarServiceImpl implements CarService<Long> {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void save(List<Car> carList) {
        carRepository.saveAll(carList);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void delete(List<Long> id) {
        carRepository.deleteAllById(id);
    }

    @Override
    public Optional<Car> find(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType) {
        return carRepository.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
    }
}
