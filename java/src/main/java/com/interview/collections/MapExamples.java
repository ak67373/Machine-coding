package com.interview.collections;

import java.util.*;

/**
 * Map Examples: HashMap, LinkedHashMap, TreeMap, Hashtable
 * Map stores key-value pairs, keys must be unique
 */
public class MapExamples {
    
    public static void main(String[] args) {
        System.out.println("=== MAP EXAMPLES ===\n");

        // 1. HashMap - No order, O(1) average, allows one null key
        System.out.println("1. HASHMAP (No order, O(1) average)");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 35);
        hashMap.put("Alice", 26); // Updates existing key
        hashMap.put(null, 0); // Allows null key
        System.out.println("HashMap: " + hashMap);
        System.out.println("Get 'Bob': " + hashMap.get("Bob"));
        System.out.println("Contains key 'Charlie': " + hashMap.containsKey("Charlie"));
        System.out.println("Contains value 30: " + hashMap.containsValue(30));
        System.out.println();

        // 2. LinkedHashMap - Maintains insertion order
        System.out.println("2. LINKEDHASHMAP (Maintains insertion order)");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("First", "1");
        linkedHashMap.put("Second", "2");
        linkedHashMap.put("Third", "3");
        System.out.println("LinkedHashMap: " + linkedHashMap); // Order maintained
        System.out.println();

        // 3. TreeMap - Sorted by keys (natural or custom)
        System.out.println("3. TREEMAP (Sorted by keys, O(log n))");
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 100);
        treeMap.put("Apple", 50);
        treeMap.put("Banana", 75);
        treeMap.put("Cherry", 60);
        System.out.println("TreeMap: " + treeMap); // Sorted alphabetically
        
        // TreeMap with custom comparator (reverse order)
        Map<String, Integer> treeMapDesc = new TreeMap<>(Collections.reverseOrder());
        treeMapDesc.putAll(treeMap);
        System.out.println("TreeMap (descending): " + treeMapDesc);
        System.out.println();

        // 4. Hashtable - Synchronized (Thread-safe), no null keys/values
        System.out.println("4. HASHTABLE (Thread-safe, no null)");
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);
        System.out.println("Hashtable: " + hashtable);
        System.out.println();

        // 5. Map Iteration Methods
        System.out.println("5. MAP ITERATION METHODS");
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Using entrySet() - Most common
        System.out.println("Using entrySet():");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Using keySet()
        System.out.println("\nUsing keySet():");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }

        // Using values()
        System.out.println("\nUsing values():");
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Using forEach (Java 8+)
        System.out.println("\nUsing forEach (lambda):");
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println();

        // 6. Compute Operations (Java 8+)
        System.out.println("6. COMPUTE OPERATIONS");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 10);
        
        // computeIfAbsent
        scores.computeIfAbsent("Bob", k -> 0);
        System.out.println("After computeIfAbsent: " + scores);
        
        // computeIfPresent
        scores.computeIfPresent("Alice", (k, v) -> v + 5);
        System.out.println("After computeIfPresent: " + scores);
        
        // merge
        scores.merge("Bob", 10, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("After merge: " + scores);
    }
}


