package com.interview.oops;

/**
 * Inheritance Example
 * Car extends Vehicle (IS-A relationship)
 */
public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;

    public Car(String brand, String model, int year, int numberOfDoors, String fuelType) {
        super(brand, model, year); // Call parent constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    // Implementing abstract methods
    @Override
    public void drive() {
        System.out.println(brand + " " + model + " is driving on the road");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " has stopped");
    }

    // Method overriding (Polymorphism)
    @Override
    public void start() {
        super.start(); // Call parent method
        System.out.println("Engine is running smoothly");
    }

    // Additional methods specific to Car
    public void honk() {
        System.out.println("Beep! Beep!");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', year=" + year +
                ", doors=" + numberOfDoors + ", fuel='" + fuelType + "'}";
    }
}


