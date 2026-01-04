package com.interview.jvm;

/**
 * JVM Internals Examples
 * Memory Model, Garbage Collection, String internals, equals/hashCode
 */
public class JVMInternals {
    
    public static void main(String[] args) {
        System.out.println("=== JVM INTERNALS EXAMPLES ===\n");

        // 1. String Pool and Intern
        System.out.println("1. STRING POOL AND INTERN");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = str3.intern();
        
        System.out.println("str1 == str2: " + (str1 == str2)); // true (same pool)
        System.out.println("str1 == str3: " + (str1 == str3)); // false (different objects)
        System.out.println("str1 == str4: " + (str1 == str4)); // true (interned)
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true (same content)
        System.out.println();

        // 2. StringBuilder vs StringBuffer
        System.out.println("2. STRINGBUILDER VS STRINGBUFFER");
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(" ").append("World");
        System.out.println("StringBuilder (not thread-safe): " + sb.toString());
        
        StringBuffer sbf = new StringBuffer();
        sbf.append("Hello").append(" ").append("World");
        System.out.println("StringBuffer (thread-safe): " + sbf.toString());
        System.out.println();

        // 3. equals() and hashCode() Contract
        System.out.println("3. EQUALS AND HASHCODE CONTRACT");
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Alice", 30);
        Person p3 = new Person("Bob", 25);
        
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.hashCode() == p2.hashCode(): " + 
                (p1.hashCode() == p2.hashCode())); // true (contract maintained)
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false
        System.out.println();

        // 4. Memory Information
        System.out.println("4. MEMORY INFORMATION");
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        
        System.out.println("Max Memory: " + maxMemory / (1024 * 1024) + " MB");
        System.out.println("Total Memory: " + totalMemory / (1024 * 1024) + " MB");
        System.out.println("Free Memory: " + freeMemory / (1024 * 1024) + " MB");
        System.out.println("Used Memory: " + usedMemory / (1024 * 1024) + " MB");
        System.out.println();

        // 5. Garbage Collection
        System.out.println("5. GARBAGE COLLECTION");
        System.gc(); // Suggest GC (not guaranteed)
        System.out.println("GC suggested");
        System.out.println();

        // 6. Immutability
        System.out.println("6. IMMUTABILITY");
        ImmutablePerson immutable = new ImmutablePerson("John", 30);
        System.out.println("Immutable person: " + immutable);
        // immutable.setName("Jane"); // Won't compile - no setter
        System.out.println();

        // 7. Pass by Value (Reference)
        System.out.println("7. PASS BY VALUE");
        int x = 10;
        changePrimitive(x);
        System.out.println("After changePrimitive: " + x); // Still 10
        
        StringBuilder stringBuilder = new StringBuilder("Hello");
        changeObject(stringBuilder);
        System.out.println("After changeObject: " + stringBuilder); // Changed
    }

    public static void changePrimitive(int value) {
        value = 20; // Won't affect original
    }

    public static void changeObject(StringBuilder sb) {
        sb.append(" World"); // Will affect original (reference copy)
    }
}

/**
 * Person class demonstrating equals() and hashCode()
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

/**
 * Immutable class
 */
final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + "}";
    }
}

