package com.interview.keywords;

/**
 * Keywords Examples: static, final, access modifiers
 */
public class KeywordsExamples {
    
    // Static variables
    private static int staticCounter = 0;
    private int instanceCounter = 0;
    
    // Final variables
    private final int finalInstanceVar = 10;
    private static final int CONSTANT = 100;
    
    public static void main(String[] args) {
        System.out.println("=== KEYWORDS EXAMPLES ===\n");
        
        // 1. Static
        System.out.println("1. STATIC KEYWORD");
        KeywordsExamples obj1 = new KeywordsExamples();
        KeywordsExamples obj2 = new KeywordsExamples();
        
        obj1.increment();
        obj2.increment();
        System.out.println("Static counter: " + staticCounter); // Shared across instances
        System.out.println("Instance counter obj1: " + obj1.instanceCounter);
        System.out.println("Instance counter obj2: " + obj2.instanceCounter);
        
        staticMethod(); // Can call without object
        System.out.println();
        
        // 2. Final
        System.out.println("2. FINAL KEYWORD");
        FinalExamples.example();
        System.out.println();
        
        // 3. Access Modifiers
        System.out.println("3. ACCESS MODIFIERS");
        AccessModifierExamples.example();
    }
    
    void increment() {
        staticCounter++;
        instanceCounter++;
    }
    
    static void staticMethod() {
        System.out.println("Static method called");
    }
}

class FinalExamples {
    // Final variable
    final int finalVar = 10;
    
    // Final method
    final void finalMethod() {
        System.out.println("Final method - cannot be overridden");
    }
    
    static void example() {
        FinalExamples obj = new FinalExamples();
        System.out.println("Final variable: " + obj.finalVar);
        // obj.finalVar = 20; // Compile error
        
        obj.finalMethod();
    }
}

// Final class
final class FinalClass {
    void method() {
        System.out.println("Final class - cannot be extended");
    }
}

class AccessModifierExamples {
    public int publicVar = 1;
    protected int protectedVar = 2;
    int defaultVar = 3; // package-private
    private int privateVar = 4;
    
    public void publicMethod() {
        System.out.println("Public method - accessible everywhere");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method - accessible in package and subclasses");
    }
    
    void defaultMethod() {
        System.out.println("Default method - accessible in same package");
    }
    
    private void privateMethod() {
        System.out.println("Private method - accessible only in same class");
    }
    
    static void example() {
        AccessModifierExamples obj = new AccessModifierExamples();
        System.out.println("Public: " + obj.publicVar);
        System.out.println("Protected: " + obj.protectedVar);
        System.out.println("Default: " + obj.defaultVar);
        System.out.println("Private: " + obj.privateVar);
        obj.publicMethod();
        obj.protectedMethod();
        obj.defaultMethod();
        obj.privateMethod();
    }
}

