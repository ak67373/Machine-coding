package com.interview.generics;

import java.util.*;

/**
 * Generics Examples
 * Generics provide type safety and eliminate casting
 */
public class GenericsExamples {
    
    public static void main(String[] args) {
        System.out.println("=== GENERICS EXAMPLES ===\n");

        // 1. Basic Generics
        System.out.println("1. BASIC GENERICS");
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> integerBox = new Box<>(42);
        System.out.println("String box: " + stringBox.get());
        System.out.println("Integer box: " + integerBox.get());
        System.out.println();

        // 2. Generic Methods
        System.out.println("2. GENERIC METHODS");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"A", "B", "C"};
        System.out.println("Print int array:");
        printArray(intArray);
        System.out.println("Print string array:");
        printArray(strArray);
        System.out.println();

        // 3. Bounded Type Parameters
        System.out.println("3. BOUNDED TYPE PARAMETERS");
        System.out.println("Max of 3, 7, 5: " + maximum(3, 7, 5));
        System.out.println("Max of 3.5, 7.2, 5.1: " + maximum(3.5, 7.2, 5.1));
        System.out.println();

        // 4. Wildcards
        System.out.println("4. WILDCARDS");
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<String> strList = Arrays.asList("A", "B", "C");
        
        printList(intList);      // Upper bounded wildcard
        printList(doubleList);   // Upper bounded wildcard
        // printList(strList);   // Won't compile - String not a Number
        
        List<Object> objList = new ArrayList<>();
        addNumbers(objList);     // Lower bounded wildcard
        System.out.println("Object list: " + objList);
        System.out.println();

        // 5. Generic Classes with Multiple Parameters
        System.out.println("5. MULTIPLE TYPE PARAMETERS");
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println("Pair: " + pair);
        System.out.println();

        // 6. Generic Collections
        System.out.println("6. GENERIC COLLECTIONS");
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        // names.add(123);  // Compile-time error
        
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        System.out.println("Scores: " + scores);
    }

    // Generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Bounded type parameter - extends Comparable
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    // Upper bounded wildcard - ? extends Number
    public static void printList(List<? extends Number> list) {
        for (Number num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Lower bounded wildcard - ? super Integer
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}

/**
 * Generic class
 */
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}

/**
 * Generic class with multiple type parameters
 */
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }
}

