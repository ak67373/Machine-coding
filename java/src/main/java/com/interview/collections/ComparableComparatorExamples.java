package com.interview.collections;

import java.util.*;

/**
 * Comparable and Comparator Examples
 * Used for sorting objects in collections
 */
public class ComparableComparatorExamples {
    
    public static void main(String[] args) {
        System.out.println("=== COMPARABLE & COMPARATOR EXAMPLES ===\n");

        // 1. Comparable - Natural ordering
        System.out.println("1. COMPARABLE (Natural Ordering)");
        List<StudentComparable> students = new ArrayList<>();
        students.add(new StudentComparable(3, "Charlie", 85));
        students.add(new StudentComparable(1, "Alice", 95));
        students.add(new StudentComparable(2, "Bob", 87));
        
        Collections.sort(students);
        System.out.println("Sorted by ID (natural order):");
        students.forEach(System.out::println);
        System.out.println();

        // 2. Comparator - Custom ordering
        System.out.println("2. COMPARATOR (Custom Ordering)");
        // Sort by name
        Collections.sort(students, Comparator.comparing(StudentComparable::getName));
        System.out.println("Sorted by name:");
        students.forEach(System.out::println);
        
        // Sort by score (descending)
        Collections.sort(students, (s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()));
        System.out.println("Sorted by score (descending):");
        students.forEach(System.out::println);
        System.out.println();

        // 3. Multiple Comparators
        System.out.println("3. MULTIPLE COMPARATORS");
        students.sort(Comparator
                .comparing(StudentComparable::getScore).reversed()  // First by score (desc)
                .thenComparing(StudentComparable::getName));        // Then by name (asc)
        System.out.println("Sorted by score (desc), then name (asc):");
        students.forEach(System.out::println);
        System.out.println();

        // 4. Comparator with Lambda
        System.out.println("4. COMPARATOR WITH LAMBDA");
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "David");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + names);
        
        names.sort((a, b) -> b.compareTo(a)); // Reverse
        System.out.println("Reverse sorted: " + names);
        System.out.println();

        // 5. Comparator with Method Reference
        System.out.println("5. COMPARATOR WITH METHOD REFERENCE");
        List<Employee> employees = Arrays.asList(
                new Employee("John", 50000),
                new Employee("Jane", 60000),
                new Employee("Bob", 45000)
        );
        
        employees.sort(Comparator.comparing(Employee::getSalary));
        System.out.println("Sorted by salary:");
        employees.forEach(System.out::println);
        
        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("Sorted by name:");
        employees.forEach(System.out::println);
    }
}

/**
 * Student class implementing Comparable (for ComparableComparatorExamples)
 */
class StudentComparable implements Comparable<StudentComparable> {
    private int id;
    private String name;
    private int score;

    public StudentComparable(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    // Natural ordering by ID
    @Override
    public int compareTo(StudentComparable other) {
        return Integer.compare(this.id, other.id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "StudentComparable{id=" + id + ", name='" + name + "', score=" + score + "}";
    }
}

/**
 * Employee class (no Comparable)
 */
class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}

