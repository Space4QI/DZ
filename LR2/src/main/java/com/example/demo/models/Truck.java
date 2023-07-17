package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "Truck")
public class Truck extends Vehicle {

    private final static String type = "TRUCK";

    @Column(name = "loadCapacity")
    private double loadCapacity;

    protected Truck() {
    }

    public Truck(String model, BigDecimal price, String fuelType, double loadCapacity) {
        super(type, model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override

    public String toString() {

        return "Truck {" + "loadCapacity=" + loadCapacity +  " }" + super.toString();
    }
}