package com.example.demo.models;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Plane")
public class Plane extends Vehicle {
    private final static String type = "PLANE";
    @Column(name = "passengerCapacity")
    private int passengerCapacity;
    @Column(name = "airline")
    private String airline;

    protected Plane() {
    }

    public Plane(String model, BigDecimal price, String fuelType, int passengerCapacity, String airline) {
        super(type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
        this.airline = airline;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override

    public String toString() {

        return "Plane {" + "passengerCapacity=" + passengerCapacity + "airline=" + airline + "}" + super.toString();
    }
}