package com.interview.java8;

/**
 * Main class to run all Java 8+ examples
 */
public class Java8Examples {
    
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   JAVA 8+ FEATURES DEMO");
        System.out.println("=========================================\n");

        StreamExamples.main(args);
        System.out.println();
        
        LambdaExamples.main(args);
        System.out.println();
        
        OptionalExamples.main(args);
        
        System.out.println("=========================================");
        System.out.println("      END OF JAVA 8+ FEATURES DEMO");
        System.out.println("=========================================");
    }
}

