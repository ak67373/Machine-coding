package com.interview.innerclasses;

/**
 * Inner Classes Examples
 * Static Inner, Non-static Inner, Local, Anonymous
 */
public class InnerClassesExamples {
    
    private String outerField = "Outer Field";
    private static String staticOuterField = "Static Outer Field";
    
    public static void main(String[] args) {
        System.out.println("=== INNER CLASSES EXAMPLES ===\n");
        
        // 1. Static Nested Class
        System.out.println("1. STATIC NESTED CLASS");
        OuterClass.StaticNestedClass staticNested = new OuterClass.StaticNestedClass();
        staticNested.display();
        System.out.println();
        
        // 2. Non-static Inner Class
        System.out.println("2. NON-STATIC INNER CLASS");
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
        System.out.println();
        
        // 3. Local Inner Class
        System.out.println("3. LOCAL INNER CLASS");
        InnerClassesExamples example = new InnerClassesExamples();
        example.localInnerClassExample();
        System.out.println();
        
        // 4. Anonymous Inner Class
        System.out.println("4. ANONYMOUS INNER CLASS");
        example.anonymousInnerClassExample();
    }
    
    // Local Inner Class
    void localInnerClassExample() {
        class LocalInner {
            void display() {
                System.out.println("Local Inner Class");
                System.out.println("Accessing outer field: " + outerField);
            }
        }
        LocalInner local = new LocalInner();
        local.display();
    }
    
    // Anonymous Inner Class
    void anonymousInnerClassExample() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class - Runnable");
            }
        };
        r.run();
    }
}

class OuterClass {
    private static String staticField = "Static Field";
    private String instanceField = "Instance Field";
    
    // Static Nested Class
    static class StaticNestedClass {
        void display() {
            System.out.println("Static Nested Class");
            System.out.println("Can access static field: " + staticField);
            // Cannot access instanceField directly
        }
    }
    
    // Non-static Inner Class
    class InnerClass {
        void display() {
            System.out.println("Non-static Inner Class");
            System.out.println("Can access static field: " + staticField);
            System.out.println("Can access instance field: " + instanceField);
        }
    }
}

