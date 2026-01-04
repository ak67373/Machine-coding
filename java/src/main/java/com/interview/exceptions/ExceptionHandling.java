package com.interview.exceptions;

/**
 * Exception Handling Examples
 * Demonstrates checked, unchecked exceptions and custom exceptions
 */
public class ExceptionHandling {
    
    public static void main(String[] args) {
        System.out.println("=== EXCEPTION HANDLING EXAMPLES ===\n");

        // 1. Try-Catch-Finally
        System.out.println("1. TRY-CATCH-FINALLY");
        try {
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
        System.out.println();

        // 2. Multiple Catch Blocks
        System.out.println("2. MULTIPLE CATCH BLOCKS");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generic exception: " + e.getMessage());
        }
        System.out.println();

        // 3. Try-With-Resources (Java 7+)
        System.out.println("3. TRY-WITH-RESOURCES");
        try (MyResource resource = new MyResource()) {
            resource.use();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } // Resource automatically closed
        System.out.println();

        // 4. Custom Exception
        System.out.println("4. CUSTOM EXCEPTION");
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Custom exception: " + e.getMessage());
        }
        System.out.println();

        // 5. Throws Keyword
        System.out.println("5. THROWS KEYWORD");
        try {
            riskyMethod();
        } catch (CheckedException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }
        System.out.println();

        // 6. Exception Propagation
        System.out.println("6. EXCEPTION PROPAGATION");
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }
        System.out.println();

        // 7. Finally and Return
        System.out.println("7. FINALLY AND RETURN");
        System.out.println("Value: " + testFinally());
    }

    // Custom exception usage
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }
        System.out.println("Age is valid");
    }

    // Throws checked exception
    public static void riskyMethod() throws CheckedException {
        throw new CheckedException("This is a checked exception");
    }

    // Exception propagation
    public static void method1() throws Exception {
        method2();
    }

    public static void method2() throws Exception {
        throw new Exception("Exception from method2");
    }

    // Finally and return
    public static int testFinally() {
        try {
            return 1;
        } finally {
            System.out.println("Finally executes before return");
            return 2; // This will override the return value
        }
    }
}

/**
 * Custom Checked Exception
 */
class CheckedException extends Exception {
    public CheckedException(String message) {
        super(message);
    }
}

/**
 * Custom Unchecked Exception
 */
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

/**
 * Resource for try-with-resources (must implement AutoCloseable)
 */
class MyResource implements AutoCloseable {
    public void use() {
        System.out.println("Using resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed");
    }
}

