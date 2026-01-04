package com.interview.oops;

/**
 * Interface Implementation
 * Circle implements Shape interface
 */
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{radius=" + radius + ", area=" + calculateArea() + 
               ", perimeter=" + calculatePerimeter() + "}";
    }
}


