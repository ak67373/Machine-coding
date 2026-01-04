package com.interview.java8;

import java.util.*;
import java.util.function.*;

/**
 * Lambda Expressions and Functional Interfaces Examples
 * Lambda expressions enable functional programming in Java
 */
public class LambdaExamples {
    
    public static void main(String[] args) {
        System.out.println("=== LAMBDA EXPRESSIONS & FUNCTIONAL INTERFACES ===\n");

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 1. Basic Lambda Expression
        System.out.println("1. BASIC LAMBDA - Sort with Comparator");
        List<String> sorted = new ArrayList<>(names);
        sorted.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted: " + sorted);
        System.out.println();

        // 2. Method References
        System.out.println("2. METHOD REFERENCES");
        // Static method reference
        List<String> upperCase = names.stream()
                .map(String::toUpperCase)
                .collect(java.util.stream.Collectors.toList());
        System.out.println("Upper case (method ref): " + upperCase);
        
        // Instance method reference
        names.forEach(System.out::println);
        System.out.println();

        // 3. Functional Interfaces
        System.out.println("3. FUNCTIONAL INTERFACES");

        // Predicate - Takes one argument, returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 5 even? " + isEven.test(5));
        System.out.println("Is 6 even? " + isEven.test(6));

        // Function - Takes one argument, returns result
        Function<String, Integer> lengthFunction = String::length;
        System.out.println("Length of 'Hello': " + lengthFunction.apply("Hello"));

        // Consumer - Takes one argument, returns void
        Consumer<String> printer = System.out::println;
        printer.accept("Hello from Consumer");

        // Supplier - Takes no argument, returns result
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random: " + randomSupplier.get());

        // UnaryOperator - Function where input and output are same type
        UnaryOperator<String> upperCaseOperator = String::toUpperCase;
        System.out.println("Uppercase: " + upperCaseOperator.apply("hello"));

        // BinaryOperator - Takes two arguments of same type, returns same type
        BinaryOperator<Integer> adder = Integer::sum;
        System.out.println("Sum: " + adder.apply(5, 3));
        System.out.println();

        // 4. Custom Functional Interface
        System.out.println("4. CUSTOM FUNCTIONAL INTERFACE");
        Calculator calculator = (a, b, operation) -> {
            switch (operation) {
                case "add": return a + b;
                case "multiply": return a * b;
                default: return 0;
            }
        };
        System.out.println("Calculate (5, 3, add): " + calculator.calculate(5, 3, "add"));
        System.out.println();

        // 5. Lambda with Collections
        System.out.println("5. LAMBDA WITH COLLECTIONS");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(n -> System.out.print(n * 2 + " "));
        System.out.println("\n");

        // 6. Lambda with Stream API
        System.out.println("6. LAMBDA WITH STREAMS");
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .filter(n -> n > 4)
                .collect(java.util.stream.Collectors.toList());
        System.out.println("Doubled and filtered: " + doubled);
        System.out.println();

        // 7. Lambda with Threads
        System.out.println("7. LAMBDA WITH THREADS");
        Thread thread = new Thread(() -> System.out.println("Running in lambda thread"));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 8. Composing Functions
        System.out.println("8. COMPOSING FUNCTIONS");
        Function<Integer, Integer> multiply = x -> x * 2;
        Function<Integer, Integer> add = x -> x + 3;
        Function<Integer, Integer> composed = multiply.andThen(add);
        System.out.println("Compose (2 * 5 + 3): " + composed.apply(5));

        Predicate<Integer> greaterThan5 = x -> x > 5;
        Predicate<Integer> lessThan10 = x -> x < 10;
        Predicate<Integer> between5And10 = greaterThan5.and(lessThan10);
        System.out.println("Is 7 between 5 and 10? " + between5And10.test(7));
    }
}

/**
 * Custom functional interface (single abstract method)
 */
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b, String operation);
}

