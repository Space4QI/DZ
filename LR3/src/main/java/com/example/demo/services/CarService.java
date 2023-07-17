package com.example.demo.services;

import com.example.demo.models.Car;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;


public interface CarService<ID> {
    void save(Car car);
    void save(List<Car> carList);
    void delete(ID id);
    void delete(List<ID> id);
    Optional<Car> find(ID id);
    List<Car> findByPriceBetweenAndFuelType(BigDecimal minPrice, BigDecimal maxPrice, String fuelType);
}
