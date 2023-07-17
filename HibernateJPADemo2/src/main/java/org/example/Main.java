package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.models.Vehicle;
import org.example.models.Car;
import org.example.models.Truck;
import org.example.models.Bike;
import org.example.models.Plane;

import java.math.BigDecimal;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate_jpa_demo");
             EntityManager em = emf.createEntityManager()) {


            Vehicle car = new Car("car", new BigDecimal(500000), "Бензин", 5);
            Vehicle truck = new Truck("truck", new BigDecimal(1000000), "Дизель", 10000);
            Vehicle bike = new Bike("bike", new BigDecimal(200000), "Бензин");
            Vehicle plane = new Plane("plane", new BigDecimal(10000000), "Авиабензин", 200);

            System.out.printf("Car: %s%n", car);
            System.out.printf("Truck: %s%n", truck);
            System.out.printf("Bike: %s%n", bike);
            System.out.printf("Plane: %s%n", plane);

            try {
                em.getTransaction().begin();
                em.persist(car);
                em.persist(truck);
                em.persist(bike);
                em.persist(plane);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction() != null)
                    em.getTransaction().rollback();
                throw e;
            }

            try {
                em.getTransaction().begin();
                List<Vehicle> vehicles = em.createQuery("SELECT v FROM Vehicle v", Vehicle.class)
                        .getResultList();
                System.out.println(vehicles);
                em.getTransaction().commit();
            } catch (Exception e) {
                if (em.getTransaction() != null)
                    em.getTransaction().rollback();
                throw e;
            }
        }
    }
}
