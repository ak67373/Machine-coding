package com.interview.oops;

/**
 * Main class demonstrating OOPs concepts:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Polymorphism (Runtime and Compile-time)
 * 4. Abstraction (Abstract classes and Interfaces)
 */
public class OOPSExamples {
    
    public static void main(String[] args) {
        System.out.println("=== OOPs Concepts Demo ===\n");

        // 1. ENCAPSULATION
        System.out.println("1. ENCAPSULATION (Data Hiding)");
        Person person = new Person("John Doe", 30, "john@example.com");
        System.out.println(person);
        person.setAge(31); // Using setter
        System.out.println("Updated age: " + person.getAge() + "\n");

        // 2. INHERITANCE
        System.out.println("2. INHERITANCE (IS-A Relationship)");
        Car car = new Car("Toyota", "Camry", 2023, 4, "Petrol");
        Bike bike = new Bike("Yamaha", "R1", 2023, false, 1000);
        System.out.println(car);
        System.out.println(bike + "\n");

        // 3. POLYMORPHISM - Runtime Polymorphism (Method Overriding)
        System.out.println("3. RUNTIME POLYMORPHISM (Method Overriding)");
        Vehicle vehicle1 = new Car("Honda", "Civic", 2022, 4, "Hybrid");
        Vehicle vehicle2 = new Bike("Kawasaki", "Ninja", 2022, false, 650);
        
        // Same method call, different behaviors (Runtime polymorphism)
        vehicle1.start();
        vehicle1.drive();
        vehicle1.stop();
        
        System.out.println();
        vehicle2.start();
        vehicle2.drive();
        vehicle2.stop();
        System.out.println();

        // 4. POLYMORPHISM - Compile-time Polymorphism (Method Overloading)
        System.out.println("4. COMPILE-TIME POLYMORPHISM (Method Overloading)");
        MathOperations math = new MathOperations();
        System.out.println("Add two ints: " + math.add(5, 10));
        System.out.println("Add three ints: " + math.add(5, 10, 15));
        System.out.println("Add two doubles: " + math.add(5.5, 10.5));
        System.out.println("Add two strings: " + math.add("Hello", " World") + "\n");

        // 5. ABSTRACTION - Abstract Class
        System.out.println("5. ABSTRACTION (Abstract Class)");
        Vehicle car2 = new Car("Tesla", "Model 3", 2023, 4, "Electric");
        car2.start(); // Concrete method
        car2.drive(); // Abstract method implementation
        car2.stop();  // Abstract method implementation
        System.out.println();

        // 6. ABSTRACTION - Interface
        System.out.println("6. ABSTRACTION (Interface)");
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        // Interface default method
        circle.display();
        rectangle.display();
        
        // Interface static method
        Shape.printPI();
        
        // Polymorphism with interface
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println();
    }
}

/**
 * Helper class for demonstrating method overloading
 */
class MathOperations {
    // Method overloading - same method name, different parameters
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }
}


