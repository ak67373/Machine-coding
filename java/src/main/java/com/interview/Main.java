package com.interview;

import com.interview.oops.OOPSExamples;
import com.interview.collections.CollectionsDemo;
import com.interview.collections.ComparableComparatorExamples;
import com.interview.collections.HashMapInternalWorking;
import com.interview.multithreading.MultithreadingDemo;
import com.interview.multithreading.AdvancedConcurrency;
import com.interview.multithreading.ThreadLocalVolatileDeadlock;
import com.interview.multithreading.CompletableFutureAdvanced;
import com.interview.multithreading.LockInterfaces;
import com.interview.java8.Java8Examples;
import com.interview.designpatterns.DesignPatternsDemo;
import com.interview.generics.GenericsExamples;
import com.interview.exceptions.ExceptionHandling;
import com.interview.jvm.JVMInternals;
import com.interview.reflection.ReflectionExamples;
import com.interview.solid.SOLIDPrinciples;
import com.interview.serialization.SerializationExamples;
import com.interview.annotations.CustomAnnotations;
import com.interview.innerclasses.InnerClassesExamples;
import com.interview.enums.EnumExamples;
import com.interview.datetime.DateTimeExamples;
import com.interview.regex.RegexExamples;
import com.interview.keywords.KeywordsExamples;

/**
 * Main class to run all interview preparation examples
 * Comprehensive guide for 5+ years experience Java developers
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║  JAVA INTERVIEW PREPARATION - COMPREHENSIVE GUIDE (5+ YOE) ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        // Run OOPs examples
        System.out.println("\n>>> STARTING OOPs EXAMPLES <<<\n");
        OOPSExamples.main(args);
        
        // Run Collections examples
        System.out.println("\n>>> STARTING COLLECTIONS EXAMPLES <<<\n");
        CollectionsDemo.main(args);
        
        // Run Advanced Collections (Comparable, Comparator)
        System.out.println("\n>>> STARTING COMPARABLE & COMPARATOR EXAMPLES <<<\n");
        ComparableComparatorExamples.main(args);
        
        // Run Generics
        System.out.println("\n>>> STARTING GENERICS EXAMPLES <<<\n");
        GenericsExamples.main(args);
        
        // Run Exception Handling
        System.out.println("\n>>> STARTING EXCEPTION HANDLING EXAMPLES <<<\n");
        ExceptionHandling.main(args);
        
        // Run Java 8+ Features
        System.out.println("\n>>> STARTING JAVA 8+ FEATURES EXAMPLES <<<\n");
        Java8Examples.main(args);
        
        // Run Design Patterns
        System.out.println("\n>>> STARTING DESIGN PATTERNS EXAMPLES <<<\n");
        DesignPatternsDemo.main(args);
        
        // Run SOLID Principles
        System.out.println("\n>>> STARTING SOLID PRINCIPLES EXAMPLES <<<\n");
        SOLIDPrinciples.main(args);
        
        // Run Multithreading examples
        System.out.println("\n>>> STARTING MULTITHREADING EXAMPLES <<<\n");
        MultithreadingDemo.main(args);
        
        // Run Advanced Concurrency
        System.out.println("\n>>> STARTING ADVANCED CONCURRENCY EXAMPLES <<<\n");
        try {
            AdvancedConcurrency.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run ThreadLocal, Volatile, Deadlock
        System.out.println("\n>>> STARTING THREADLOCAL, VOLATILE, DEADLOCK EXAMPLES <<<\n");
        try {
            ThreadLocalVolatileDeadlock.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run CompletableFuture Advanced
        System.out.println("\n>>> STARTING COMPLETABLEFUTURE ADVANCED EXAMPLES <<<\n");
        try {
            CompletableFutureAdvanced.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run Lock Interfaces
        System.out.println("\n>>> STARTING LOCK INTERFACES EXAMPLES <<<\n");
        try {
            LockInterfaces.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run HashMap Internal Working
        System.out.println("\n>>> STARTING HASHMAP INTERNAL WORKING <<<\n");
        HashMapInternalWorking.main(args);
        
        // Run JVM Internals
        System.out.println("\n>>> STARTING JVM INTERNALS EXAMPLES <<<\n");
        JVMInternals.main(args);
        
        // Run Reflection
        System.out.println("\n>>> STARTING REFLECTION API EXAMPLES <<<\n");
        try {
            ReflectionExamples.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run Serialization
        System.out.println("\n>>> STARTING SERIALIZATION EXAMPLES <<<\n");
        try {
            SerializationExamples.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run Custom Annotations
        System.out.println("\n>>> STARTING CUSTOM ANNOTATIONS EXAMPLES <<<\n");
        try {
            CustomAnnotations.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Run Inner Classes
        System.out.println("\n>>> STARTING INNER CLASSES EXAMPLES <<<\n");
        InnerClassesExamples.main(args);
        
        // Run Enums
        System.out.println("\n>>> STARTING ENUM EXAMPLES <<<\n");
        EnumExamples.main(args);
        
        // Run Date/Time API
        System.out.println("\n>>> STARTING DATE/TIME API EXAMPLES <<<\n");
        DateTimeExamples.main(args);
        
        // Run Regex
        System.out.println("\n>>> STARTING REGEX EXAMPLES <<<\n");
        RegexExamples.main(args);
        
        // Run Keywords
        System.out.println("\n>>> STARTING KEYWORDS EXAMPLES <<<\n");
        KeywordsExamples.main(args);
        
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║           ALL EXAMPLES COMPLETED SUCCESSFULLY!            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}

