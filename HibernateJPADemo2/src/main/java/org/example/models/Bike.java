package org.example.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "Bike")
public class Bike extends Vehicle {
    private final static String type = "BIKE";

    protected Bike(){
    }
    public Bike(String model, BigDecimal price, String fuelType) {

        super(type, model, price, fuelType);
    }

    @Override

    public String toString() {

        return super.toString();
    }
}
