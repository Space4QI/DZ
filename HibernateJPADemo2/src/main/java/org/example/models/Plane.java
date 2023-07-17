package org.example.models;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Plane")
public class Plane extends Vehicle {
    private final static String type = "PLANE";
    @Column(name = "passengerCapacity")
    private int passengerCapacity;

    protected Plane() {
    }

    public Plane(String model, BigDecimal price, String fuelType, int passengerCapacity) {
        super(type, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override

    public String toString() {

        return "Plane {" + "passengerCapacity=" + passengerCapacity +  " }" + super.toString();
    }
}