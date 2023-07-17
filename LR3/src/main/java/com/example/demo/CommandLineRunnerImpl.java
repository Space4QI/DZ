package com.example.demo;

import com.example.demo.models.Bike;
import com.example.demo.models.Car;
import com.example.demo.models.Plane;
import com.example.demo.models.Truck;
import com.example.demo.services.BikeService;
import com.example.demo.services.CarService;
import com.example.demo.services.PlaneService;
import com.example.demo.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CarService carService;
    private final BikeService bikeService;
    private final PlaneService planeService;
    private final TruckService truckService;

    @Autowired
    public CommandLineRunnerImpl(CarService carService, BikeService bikeService, PlaneService planeService,
                                 TruckService truckService) {
        this.carService = carService;
        this.bikeService = bikeService;
        this.planeService = planeService;
        this.truckService = truckService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        // Получение списка транспортных средств по заданному ценовому диапазону и типу топлива
        BigDecimal minPrice = new BigDecimal("100000");
        BigDecimal maxPrice = new BigDecimal("500000");
        String fuelType = "Бензин";
        List<Car> cars = carService.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
        List<Truck> trucks = truckService.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
        List<Bike> bikes = bikeService.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);
        List<Plane> planes = planeService.findByPriceBetweenAndFuelType(minPrice, maxPrice, fuelType);

        // Вывод результатов
        System.out.println("Список автомобилей:");
        cars.forEach(System.out::println);

        System.out.println("Список грузовиков:");
        trucks.forEach(System.out::println);

        System.out.println("Список байков:");
        bikes.forEach(System.out::println);

        System.out.println("Список самолетов:");
        planes.forEach(System.out::println);
    }

    // insert query
    private void seedData() throws Exception {
        Car car = new Car("car", new BigDecimal(500000), "Бензин", 5);
        Truck truck = new Truck("truck", new BigDecimal(1000000), "Дизель", 10000);
        Bike bike = new Bike("bike", new BigDecimal(200000), "Бензин");
        Plane plane = new Plane("plane", new BigDecimal(10000000), "Авиабензин", 200, "Аэрофлот");

        carService.save(car);
        bikeService.save(bike);
        planeService.save(plane);
        truckService.save(truck);
    }
}
