package org.example.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Vehicle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @Column (name = "type", length = 255, nullable = false)
    private String type;

    @Column (name = "model", length = 255, nullable = false)
    private String model;

    @Column (name = "price", length = 255, nullable = false)
    private BigDecimal price;

    @Column (name = "fuelType", length = 255, nullable = false)
    private String fuelType;

    protected Vehicle(){
    }
    public Vehicle(String type, String model, BigDecimal price, String fuelType){
        this.type = type;
        this.model = model;
        this.price = price;
        this.fuelType = fuelType;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}