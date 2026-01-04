package com.interview.multithreading;

import java.util.concurrent.*;

/**
 * ExecutorService Examples:
 * 1. SingleThreadExecutor
 * 2. FixedThreadPool
 * 3. CachedThreadPool
 * 4. ScheduledThreadPool
 * 5. Callable and Future
 */
public class ExecutorServiceExample {
    
    public static void main(String[] args) {
        System.out.println("=== EXECUTORSERVICE EXAMPLES ===\n");

        // 1. SingleThreadExecutor
        System.out.println("1. SINGLETHREADEXECUTOR");
        ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            singleExecutor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        singleExecutor.shutdown();
        try {
            singleExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 2. FixedThreadPool
        System.out.println("2. FIXEDTHREADPOOL (3 threads)");
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            fixedExecutor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        fixedExecutor.shutdown();
        try {
            fixedExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 3. CachedThreadPool
        System.out.println("3. CACHEDTHREADPOOL");
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            cachedExecutor.submit(() -> {
                System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
            });
        }
        cachedExecutor.shutdown();
        try {
            cachedExecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 4. ScheduledThreadPool
        System.out.println("4. SCHEDULEDTHREADPOOL");
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);
        
        // Schedule task to run after delay
        scheduledExecutor.schedule(() -> {
            System.out.println("Delayed task executed");
        }, 1, TimeUnit.SECONDS);
        
        // Schedule task to run periodically
        ScheduledFuture<?> future = scheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed");
        }, 0, 500, TimeUnit.MILLISECONDS);
        
        // Cancel after 2 seconds
        scheduledExecutor.schedule(() -> {
            future.cancel(true);
            scheduledExecutor.shutdown();
        }, 2, TimeUnit.SECONDS);
        
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 5. Callable and Future
        System.out.println("5. CALLABLE AND FUTURE");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // Submit Callable tasks
        Future<Integer> future1 = executor.submit(new SumTask(1, 10));
        Future<Integer> future2 = executor.submit(new SumTask(11, 20));
        Future<Integer> future3 = executor.submit(new SumTask(21, 30));
        
        try {
            System.out.println("Sum 1-10: " + future1.get());
            System.out.println("Sum 11-20: " + future2.get());
            System.out.println("Sum 21-30: " + future3.get());
            
            int total = future1.get() + future2.get() + future3.get();
            System.out.println("Total sum: " + total);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
        System.out.println();

        // 6. CompletableFuture (Java 8+)
        System.out.println("6. COMPLETABLEFUTURE");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        
        CompletableFuture<String> futureResult = completableFuture
                .thenApply(s -> s + " World")
                .thenApply(String::toUpperCase);
        
        try {
            System.out.println("Result: " + futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Callable task that returns a result
 */
class SumTask implements Callable<Integer> {
    private int start;
    private int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        Thread.sleep(100); // Simulate some work
        return sum;
    }
}


