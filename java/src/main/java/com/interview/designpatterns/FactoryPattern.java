package com.interview.designpatterns;

/**
 * Factory Pattern Examples
 * Creates objects without specifying the exact class
 */
public class FactoryPattern {
    
    public static void main(String[] args) {
        System.out.println("=== FACTORY PATTERN EXAMPLES ===\n");

        // Simple Factory
        System.out.println("1. SIMPLE FACTORY");
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();
        
        Vehicle bike = VehicleFactory.createVehicle("bike");
        bike.drive();
        System.out.println();

        // Factory Method Pattern
        System.out.println("2. FACTORY METHOD PATTERN");
        VehicleFactoryMethod carFactory = new CarFactory();
        Vehicle car2 = carFactory.createVehicle();
        car2.drive();
        
        VehicleFactoryMethod bikeFactory = new BikeFactory();
        Vehicle bike2 = bikeFactory.createVehicle();
        bike2.drive();
        System.out.println();

        // Abstract Factory Pattern
        System.out.println("3. ABSTRACT FACTORY PATTERN");
        AbstractVehicleFactory modernFactory = new ModernVehicleFactory();
        Vehicle modernCar = modernFactory.createCar();
        Vehicle modernBike = modernFactory.createBike();
        modernCar.drive();
        modernBike.drive();
        
        AbstractVehicleFactory vintageFactory = new VintageVehicleFactory();
        Vehicle vintageCar = vintageFactory.createCar();
        Vehicle vintageBike = vintageFactory.createBike();
        vintageCar.drive();
        vintageBike.drive();
    }
}

// ========== Simple Factory ==========
interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike");
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if ("car".equalsIgnoreCase(type)) {
            return new Car();
        } else if ("bike".equalsIgnoreCase(type)) {
            return new Bike();
        }
        throw new IllegalArgumentException("Unknown vehicle type");
    }
}

// ========== Factory Method Pattern ==========
abstract class VehicleFactoryMethod {
    public abstract Vehicle createVehicle();
    
    public void assembleVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.drive();
    }
}

class CarFactory extends VehicleFactoryMethod {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactoryMethod {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}

// ========== Abstract Factory Pattern ==========
interface AbstractVehicleFactory {
    Vehicle createCar();
    Vehicle createBike();
}

class ModernVehicleFactory implements AbstractVehicleFactory {
    @Override
    public Vehicle createCar() {
        return new ModernCar();
    }

    @Override
    public Vehicle createBike() {
        return new ModernBike();
    }
}

class VintageVehicleFactory implements AbstractVehicleFactory {
    @Override
    public Vehicle createCar() {
        return new VintageCar();
    }

    @Override
    public Vehicle createBike() {
        return new VintageBike();
    }
}

class ModernCar implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a modern car");
    }
}

class ModernBike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a modern bike");
    }
}

class VintageCar implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a vintage car");
    }
}

class VintageBike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a vintage bike");
    }
}

