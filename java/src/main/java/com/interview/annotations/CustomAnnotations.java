package com.interview.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Custom Annotations Examples
 */
public class CustomAnnotations {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== CUSTOM ANNOTATIONS ===\n");
        
        // Process method annotations
        Class<?> clazz = TestClass.class;
        Method[] methods = clazz.getDeclaredMethods();
        
        for (Method method : methods) {
            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Author: " + author.name());
                System.out.println("Date: " + author.date());
                System.out.println();
            }
            
            if (method.isAnnotationPresent(Version.class)) {
                Version version = method.getAnnotation(Version.class);
                System.out.println("Method: " + method.getName() + " - Version: " + version.value());
                System.out.println();
            }
        }
    }
}

// Marker annotation (no elements)
@interface TestAnnotation {
}

// Single value annotation
@interface Version {
    double value();
}

// Multi-value annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author {
    String name();
    String date();
}

// Class-level annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ClassInfo {
    String author();
    String version();
}

@ClassInfo(author = "John Doe", version = "1.0")
class TestClass {
    @Author(name = "Alice", date = "2024-01-01")
    @Version(1.0)
    public void method1() {
        System.out.println("Method 1");
    }
    
    @Author(name = "Bob", date = "2024-01-02")
    @Version(2.0)
    public void method2() {
        System.out.println("Method 2");
    }
    
    public void method3() {
        System.out.println("Method 3 - No annotations");
    }
}

