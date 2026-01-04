package com.interview.solid;

/**
 * SOLID Principles Examples
 * Single Responsibility, Open-Closed, Liskov Substitution, 
 * Interface Segregation, Dependency Inversion
 */
public class SOLIDPrinciples {
    
    public static void main(String[] args) {
        System.out.println("=== SOLID PRINCIPLES EXAMPLES ===\n");

        // Single Responsibility Principle
        System.out.println("1. SINGLE RESPONSIBILITY PRINCIPLE");
        UserService userService = new UserService();
        userService.createUser("Alice");
        
        EmailService emailService = new EmailService();
        emailService.sendEmail("alice@example.com", "Welcome!");
        System.out.println();

        // Open-Closed Principle
        System.out.println("2. OPEN-CLOSED PRINCIPLE");
        Rectangle rectangle = new Rectangle(5, 4);
        Circle circle = new Circle(3);
        
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Rectangle area: " + calculator.calculateArea(rectangle));
        System.out.println("Circle area: " + calculator.calculateArea(circle));
        System.out.println();

        // Liskov Substitution Principle
        System.out.println("3. LISKOV SUBSTITUTION PRINCIPLE");
        Bird sparrow = new Sparrow();
        sparrow.fly();
        
        Bird penguin = new Penguin();
        penguin.fly(); // Should not break
        System.out.println();

        // Interface Segregation Principle
        System.out.println("4. INTERFACE SEGREGATION PRINCIPLE");
        Workable humanWorkable = new Human();
        Eatable humanEatable = new Human();
        humanWorkable.work();
        humanEatable.eat();
        
        Workable robot = new Robot();
        robot.work();
        // robot.eat(); // Not available - good!
        System.out.println();

        // Dependency Inversion Principle
        System.out.println("5. DEPENDENCY INVERSION PRINCIPLE");
        Database mysqlDatabase = new MySQLDatabase();
        UserRepository userRepo = new UserRepository(mysqlDatabase);
        userRepo.save("Alice");
        
        Database postgresDatabase = new PostgreSQLDatabase();
        UserRepository userRepo2 = new UserRepository(postgresDatabase);
        userRepo2.save("Bob");
        System.out.println();
    }
}

// ========== Single Responsibility Principle ==========
class UserService {
    public void createUser(String name) {
        System.out.println("Creating user: " + name);
    }
}

class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Sending email to " + to + ": " + message);
    }
}

// ========== Open-Closed Principle ==========
interface Shape {
    double calculateArea();
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea(); // Open for extension, closed for modification
    }
}

// ========== Liskov Substitution Principle ==========
class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        System.out.println("Penguin cannot fly, but this is okay");
        // Don't throw exception - maintain substitutability
    }
}

// ========== Interface Segregation Principle ==========
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
    // No eat() method - robots don't eat
}

// ========== Dependency Inversion Principle ==========
interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }
}

class UserRepository {
    private Database database; // Depend on abstraction, not concrete class

    public UserRepository(Database database) {
        this.database = database;
    }

    public void save(String data) {
        database.save(data);
    }
}

