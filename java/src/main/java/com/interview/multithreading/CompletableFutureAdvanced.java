package com.interview.multithreading;

import java.util.concurrent.*;

/**
 * CompletableFuture Comprehensive Examples
 */
public class CompletableFutureAdvanced {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== COMPLETABLEFUTURE ADVANCED EXAMPLES ===\n");
        
        // 1. Creating CompletableFuture
        System.out.println("1. CREATING COMPLETABLEFUTURE");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Hello";
        });
        System.out.println("Future1 result: " + future1.get());
        System.out.println();
        
        // 2. thenApply (transform result)
        System.out.println("2. THENAPPLY (TRANSFORM)");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World")
                .thenApply(s -> s.toUpperCase())
                .thenApply(s -> s + "!");
        System.out.println("Future2 result: " + future2.get());
        System.out.println();
        
        // 3. thenCompose (chain futures)
        System.out.println("3. THENCOMPOSE (CHAIN)");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
        System.out.println("Future3 result: " + future3.get());
        System.out.println();
        
        // 4. thenCombine (combine two futures)
        System.out.println("4. THENCOMBINE (COMBINE)");
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> "World"), 
                        (s1, s2) -> s1 + " " + s2);
        System.out.println("Future4 result: " + future4.get());
        System.out.println();
        
        // 5. allOf and anyOf
        System.out.println("5. ALLOF AND ANYOF");
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Task1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Task2");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Task3");
        
        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
        all.get();
        System.out.println("All completed");
        
        CompletableFuture<Object> any = CompletableFuture.anyOf(f1, f2, f3);
        System.out.println("Any result: " + any.get());
        System.out.println();
        
        // 6. Exception handling
        System.out.println("6. EXCEPTION HANDLING");
        CompletableFuture<String> future5 = CompletableFuture.<String>supplyAsync(() -> {
            throw new RuntimeException("Error!");
        }).handle((result, ex) -> {
            if (ex != null) {
                return "Handled: " + ex.getMessage();
            }
            return result != null ? result : "No result";
        });
        System.out.println("Future5 result: " + future5.get());
        System.out.println();
        
        // 7. thenAccept and thenRun
        System.out.println("7. THENACCEPT AND THENTUN");
        CompletableFuture.supplyAsync(() -> "Result")
                .thenAccept(r -> System.out.println("Consumed: " + r))
                .thenRun(() -> System.out.println("Completed"))
                .get();
    }
}

