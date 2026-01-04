package com.interview.oops;

/**
 * Inheritance Example
 * Bike extends Vehicle (IS-A relationship)
 */
public class Bike extends Vehicle {
    private boolean hasSideCar;
    private int engineCC;

    public Bike(String brand, String model, int year, boolean hasSideCar, int engineCC) {
        super(brand, model, year);
        this.hasSideCar = hasSideCar;
        this.engineCC = engineCC;
    }

    @Override
    public void drive() {
        System.out.println(brand + " " + model + " is riding on the road");
    }

    @Override
    public void stop() {
        System.out.println(brand + " " + model + " has stopped");
    }

    // Additional methods specific to Bike
    public void wheelie() {
        System.out.println("Performing a wheelie!");
    }

    public boolean hasSideCar() {
        return hasSideCar;
    }

    public int getEngineCC() {
        return engineCC;
    }

    @Override
    public String toString() {
        return "Bike{brand='" + brand + "', model='" + model + "', year=" + year +
                ", sideCar=" + hasSideCar + ", engineCC=" + engineCC + "}";
    }
}


