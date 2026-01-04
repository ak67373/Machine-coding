package com.interview.collections;

import java.util.HashMap;

/**
 * HashMap Internal Working Detailed Explanation
 */
public class HashMapInternalWorking {
    
    public static void main(String[] args) {
        System.out.println("=== HASHMAP INTERNAL WORKING ===\n");
        
        // 1. Basic operations
        System.out.println("1. BASIC OPERATIONS");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        System.out.println("Map: " + map);
        System.out.println("Get 'Two': " + map.get("Two"));
        System.out.println();
        
        // 2. Hash code and index calculation
        System.out.println("2. HASH CODE AND INDEX");
        String key = "One";
        int hashCode = key.hashCode();
        System.out.println("Key: " + key);
        System.out.println("HashCode: " + hashCode);
        System.out.println("Index calculation: hashCode % capacity");
        System.out.println();
        
        // 3. Collision handling
        System.out.println("3. COLLISION HANDLING");
        System.out.println("HashMap uses chaining (LinkedList/Tree) for collisions");
        System.out.println("In Java 8+, if bucket has > 8 nodes, converts to TreeMap");
        System.out.println();
        
        // 4. Load factor and resizing
        System.out.println("4. LOAD FACTOR AND RESIZING");
        System.out.println("Default initial capacity: 16");
        System.out.println("Default load factor: 0.75");
        System.out.println("Resize when: size > capacity * load factor");
        System.out.println("Resize doubles the capacity");
        System.out.println();
        
        // 5. Null key handling
        System.out.println("5. NULL KEY HANDLING");
        map.put(null, 0);
        System.out.println("Null key value: " + map.get(null));
        System.out.println("HashMap allows one null key");
        System.out.println();
        
        // 6. Key characteristics for HashMap
        System.out.println("6. KEY REQUIREMENTS");
        System.out.println("Keys should have:");
        System.out.println("  - Proper hashCode() implementation");
        System.out.println("  - Proper equals() implementation");
        System.out.println("  - hashCode() and equals() contract must be maintained");
        System.out.println();
        
        // 7. Example with custom object
        System.out.println("7. CUSTOM OBJECT AS KEY");
        HashMap<EmployeeKey, String> employeeMap = new HashMap<>();
        EmployeeKey key1 = new EmployeeKey(1, "Alice");
        EmployeeKey key2 = new EmployeeKey(1, "Alice");
        employeeMap.put(key1, "Developer");
        System.out.println("Key1 equals Key2: " + key1.equals(key2));
        System.out.println("Get with key2: " + employeeMap.get(key2));
        System.out.println("This works because EmployeeKey has proper equals() and hashCode()");
    }
}

class EmployeeKey {
    private int id;
    private String name;
    
    public EmployeeKey(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeKey that = (EmployeeKey) obj;
        return id == that.id && name.equals(that.name);
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }
}

