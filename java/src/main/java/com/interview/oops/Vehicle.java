package com.interview.oops;

/**
 * Abstraction Example using Abstract Class
 * Abstract class cannot be instantiated
 */
public abstract class Vehicle {
    // Protected fields (accessible in subclasses)
    protected String brand;
    protected String model;
    protected int year;

    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Concrete method
    public void start() {
        System.out.println(brand + " " + model + " is starting...");
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void drive();

    public abstract void stop();

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}


