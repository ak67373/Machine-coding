package com.interview.collections;

import java.util.*;

/**
 * List Examples: ArrayList, LinkedList, Vector
 * List maintains insertion order and allows duplicates
 */
public class ListExamples {
    
    public static void main(String[] args) {
        System.out.println("=== LIST EXAMPLES ===\n");

        // 1. ArrayList - Dynamic array, fast random access
        System.out.println("1. ARRAYLIST");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        arrayList.add("Apple"); // Allows duplicates
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Get index 1: " + arrayList.get(1));
        System.out.println("Size: " + arrayList.size());
        System.out.println("Contains 'Banana': " + arrayList.contains("Banana"));
        System.out.println();

        // 2. LinkedList - Doubly linked list, fast insertion/deletion
        System.out.println("2. LINKEDLIST");
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.addFirst(5);  // Specific to LinkedList
        linkedList.addLast(40);  // Specific to LinkedList
        System.out.println("LinkedList: " + linkedList);
        System.out.println("First element: " + ((LinkedList<Integer>) linkedList).getFirst());
        System.out.println("Last element: " + ((LinkedList<Integer>) linkedList).getLast());
        System.out.println();

        // 3. Vector - Synchronized ArrayList (Thread-safe)
        System.out.println("3. VECTOR (Thread-safe)");
        Vector<String> vector = new Vector<>();
        vector.add("One");
        vector.add("Two");
        vector.add("Three");
        System.out.println("Vector: " + vector);
        System.out.println("Capacity: " + vector.capacity());
        System.out.println();

        // 4. Stack - LIFO (Last In First Out)
        System.out.println("4. STACK (LIFO)");
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);
        System.out.println("Peek (top): " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        System.out.println();

        // 5. Common List Operations
        System.out.println("5. COMMON LIST OPERATIONS");
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        
        // Iterator
        System.out.print("Iterator: ");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // Enhanced for loop
        System.out.print("Enhanced for: ");
        for (String item : list) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Lambda forEach (Java 8+)
        System.out.print("forEach (lambda): ");
        list.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // ListIterator (bidirectional)
        System.out.print("ListIterator (reverse): ");
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println("\n");
    }
}


