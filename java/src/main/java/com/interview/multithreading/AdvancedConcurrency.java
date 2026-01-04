package com.interview.multithreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Advanced Concurrency Examples
 * CountDownLatch, CyclicBarrier, Semaphore, Atomic classes, ForkJoinPool
 */
public class AdvancedConcurrency {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ADVANCED CONCURRENCY EXAMPLES ===\n");

        // 1. CountDownLatch - Wait for threads to complete
        System.out.println("1. COUNTDOWNLATCH");
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        for (int i = 0; i < 3; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " completed");
                    latch.countDown();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        latch.await(); // Wait for all tasks to complete
        System.out.println("All tasks completed\n");
        executor.shutdown();
        System.out.println();

        // 2. CyclicBarrier - Synchronize threads at a barrier
        System.out.println("2. CYCLICBARRIER");
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads reached the barrier");
        });
        
        ExecutorService executor2 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            final int threadId = i;
            executor2.submit(() -> {
                try {
                    System.out.println("Thread " + threadId + " reached barrier");
                    barrier.await();
                    System.out.println("Thread " + threadId + " passed barrier");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        Thread.sleep(2000);
        executor2.shutdown();
        System.out.println();

        // 3. Semaphore - Control access to a resource
        System.out.println("3. SEMAPHORE");
        Semaphore semaphore = new Semaphore(2); // Allow 2 permits
        ExecutorService executor3 = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor3.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Task " + taskId + " acquired permit");
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " released permit");
                    semaphore.release();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        
        Thread.sleep(3000);
        executor3.shutdown();
        System.out.println();

        // 4. Atomic Classes - Thread-safe operations without synchronization
        System.out.println("4. ATOMIC CLASSES");
        AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executor4 = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 5; i++) {
            executor4.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicInt.incrementAndGet();
                }
            });
        }
        
        executor4.shutdown();
        executor4.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Atomic integer value: " + atomicInt.get());
        System.out.println("Compare and set (1000, 5000): " + 
                atomicInt.compareAndSet(5000, 10000));
        System.out.println("Value after CAS: " + atomicInt.get());
        System.out.println();

        // 5. AtomicReference
        System.out.println("5. ATOMICREFERENCE");
        AtomicReference<String> atomicRef = new AtomicReference<>("Initial");
        System.out.println("Initial value: " + atomicRef.get());
        atomicRef.compareAndSet("Initial", "Updated");
        System.out.println("Updated value: " + atomicRef.get());
        System.out.println();

        // 6. ForkJoinPool - For recursive tasks
        System.out.println("6. FORKJOINPOOL");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        RecursiveTask<Integer> task = new SumTaskAdvanced(0, 1000);
        Integer result = forkJoinPool.invoke(task);
        System.out.println("Sum from 0 to 1000: " + result);
        forkJoinPool.shutdown();
    }
}

/**
 * RecursiveTask for ForkJoinPool (Advanced Concurrency)
 */
class SumTaskAdvanced extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 100;
    private int start;
    private int end;

    public SumTaskAdvanced(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Base case: compute directly
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // Divide and conquer
            int mid = (start + end) / 2;
            SumTaskAdvanced leftTask = new SumTaskAdvanced(start, mid);
            SumTaskAdvanced rightTask = new SumTaskAdvanced(mid + 1, end);
            
            leftTask.fork(); // Fork left task
            int rightResult = rightTask.compute(); // Compute right task
            int leftResult = leftTask.join(); // Join left task
            
            return leftResult + rightResult;
        }
    }
}

