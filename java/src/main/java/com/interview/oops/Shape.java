package com.interview.oops;

/**
 * Interface Example
 * Interface for abstraction - all methods are abstract by default
 */
public interface Shape {
    // Interface constants (public static final by default)
    double PI = 3.14159;

    // Abstract methods (public abstract by default)
    double calculateArea();
    double calculatePerimeter();

    // Default method (Java 8+)
    default void display() {
        System.out.println("This is a " + getClass().getSimpleName());
    }

    // Static method (Java 8+)
    static void printPI() {
        System.out.println("Value of PI: " + PI);
    }
}


