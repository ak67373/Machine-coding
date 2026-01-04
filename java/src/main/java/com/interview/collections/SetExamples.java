package com.interview.collections;

import java.util.*;

/**
 * Set Examples: HashSet, LinkedHashSet, TreeSet
 * Set does not allow duplicates
 */
public class SetExamples {
    
    public static void main(String[] args) {
        System.out.println("=== SET EXAMPLES ===\n");

        // 1. HashSet - No order, fastest operations, uses hashCode()
        System.out.println("1. HASHSET (No order, O(1) average)");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        hashSet.add("Apple"); // Duplicate, won't be added
        hashSet.add("Date");
        System.out.println("HashSet: " + hashSet); // Order may vary
        System.out.println("Size: " + hashSet.size()); // 4 (duplicate ignored)
        System.out.println("Contains 'Banana': " + hashSet.contains("Banana"));
        System.out.println();

        // 2. LinkedHashSet - Maintains insertion order
        System.out.println("2. LINKEDHASHSET (Maintains insertion order)");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("First");
        linkedHashSet.add("Second");
        linkedHashSet.add("Third");
        linkedHashSet.add("First"); // Duplicate ignored
        System.out.println("LinkedHashSet: " + linkedHashSet); // Order maintained
        System.out.println();

        // 3. TreeSet - Sorted order (natural or custom)
        System.out.println("3. TREESET (Sorted order, O(log n))");
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(20);
        treeSet.add(80);
        treeSet.add(10);
        treeSet.add(50); // Duplicate ignored
        System.out.println("TreeSet: " + treeSet); // Sorted: [10, 20, 50, 80]
        
        // TreeSet with custom comparator (descending)
        Set<Integer> treeSetDesc = new TreeSet<>(Collections.reverseOrder());
        treeSetDesc.addAll(treeSet);
        System.out.println("TreeSet (descending): " + treeSetDesc);
        System.out.println();

        // 4. Set Operations (Union, Intersection, Difference)
        System.out.println("4. SET OPERATIONS");
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        
        // Union
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + union);
        
        // Intersection
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);
        
        // Difference
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
        System.out.println();

        // 5. Custom Object in HashSet (must override hashCode and equals)
        System.out.println("5. CUSTOM OBJECT IN HASHSET");
        Set<Student> students = new HashSet<>();
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(1, "Alice")); // Duplicate (same id and name)
        System.out.println("Students: " + students);
        System.out.println("Size: " + students.size()); // 2 (duplicate ignored)
    }
}

/**
 * Student class demonstrating hashCode() and equals() for Set
 */
class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Must override equals() for Set to work correctly
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    // Must override hashCode() when overriding equals()
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}


