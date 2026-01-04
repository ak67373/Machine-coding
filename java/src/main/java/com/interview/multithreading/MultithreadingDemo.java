package com.interview.multithreading;

/**
 * Main class to run all multithreading examples
 */
public class MultithreadingDemo {
    
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   JAVA MULTITHREADING DEMO");
        System.out.println("=========================================\n");

        // Run all multithreading examples
        ThreadCreationExample.main(args);
        System.out.println();
        
        SynchronizationExample.main(args);
        System.out.println();
        
        ExecutorServiceExample.main(args);
        System.out.println();
        
        ProducerConsumerExample.main(args);
        System.out.println();
        
        ConcurrentCollectionsExample.main(args);

        System.out.println("=========================================");
        System.out.println("      END OF MULTITHREADING DEMO");
        System.out.println("=========================================");
    }
}


