package org.example.models;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "Car")
public class Car extends Vehicle {
    private final static String type = "CAR";
    @Column (name = "seats")
    private int seats;

    protected Car() {
    }
    public Car(String model, BigDecimal price, String fuelType, int seats) {
        super(type, model, price, fuelType);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override

    public String toString() {

        return "Car {" + "seats=" + seats +  " }" + super.toString();
    }
}