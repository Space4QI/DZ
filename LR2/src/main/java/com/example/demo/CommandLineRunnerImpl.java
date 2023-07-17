package com.example.demo;

import com.example.demo.models.Bike;
import com.example.demo.models.Car;
import com.example.demo.models.Plane;
import com.example.demo.models.Truck;
import com.example.demo.repositories.BikeRepository;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.PlaneRepository;
import com.example.demo.repositories.TruckRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final BikeRepository bikeRepository;
    private final CarRepository carRepository;
    private final PlaneRepository planeRepository;
    private final TruckRepository truckRepository;

    public CommandLineRunnerImpl(BikeRepository bikeRepository, CarRepository carRepository, PlaneRepository planeRepository,
                                 TruckRepository truckRepository) {
        this.bikeRepository = bikeRepository;
        this.carRepository = carRepository;
        this.planeRepository = planeRepository;
        this.truckRepository = truckRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        printAllCar();
        printAllBike();
        printAllPlane();
        printAllTruck();

    }
// insert query
    private void seedData() throws Exception{
        Car car = new Car("car", new BigDecimal(500000), "Бензин", 5);
        Truck truck= new Truck("truck", new BigDecimal(1000000), "Дизель", 10000);
        Bike bike = new Bike("bike", new BigDecimal(200000), "Бензин");
        Plane plane= new Plane("plane", new BigDecimal(10000000), "Авиабензин", 200, "Аэрофлот");

        carRepository.save(car);
        truckRepository.save(truck);
        bikeRepository.save(bike);
        planeRepository.save(plane);


    }
// select query
    private void printAllCar() {
        carRepository.findAll().forEach(System.out::println);
    }
    private void printAllBike() {
        bikeRepository.findAll().forEach(System.out::println);
    }
    private void printAllPlane() {
        carRepository.findAll().forEach(System.out::println);
    }
    private void printAllTruck() {
        carRepository.findAll().forEach(System.out::println);
    }

// delete query
    private void deleteCar(Car car){
        carRepository.delete(car);
    }
    private void deleteBike(Bike bike){
        bikeRepository.delete(bike);
    }
    private void deletePlane(Plane plane){
        planeRepository.delete(plane);
    }
    private void deleteTruck(Truck truck){
        truckRepository.delete(truck);
    }

}
