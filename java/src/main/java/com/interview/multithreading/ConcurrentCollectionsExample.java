package com.interview.multithreading;

import java.util.concurrent.*;

/**
 * Concurrent Collections Examples:
 * 1. ConcurrentHashMap
 * 2. CopyOnWriteArrayList
 * 3. BlockingQueue implementations
 * 4. ConcurrentLinkedQueue
 */
public class ConcurrentCollectionsExample {
    
    public static void main(String[] args) {
        System.out.println("=== CONCURRENT COLLECTIONS ===\n");

        // 1. ConcurrentHashMap - Thread-safe HashMap
        System.out.println("1. CONCURRENTHASHMAP");
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        
        // Multiple threads can safely add/update
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int key = i;
            executor.submit(() -> {
                concurrentMap.put("Key" + key, key * 10);
            });
        }
        
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("ConcurrentHashMap size: " + concurrentMap.size());
        System.out.println("ConcurrentHashMap: " + concurrentMap);
        System.out.println();

        // 2. CopyOnWriteArrayList - Thread-safe ArrayList
        System.out.println("2. COPYONWRITEARRAYLIST");
        CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>();
        copyOnWriteList.add("One");
        copyOnWriteList.add("Two");
        copyOnWriteList.add("Three");
        
        // Safe to iterate while modifying (creates snapshot)
        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        executor2.submit(() -> {
            for (String item : copyOnWriteList) {
                System.out.println("Reading: " + item);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        executor2.submit(() -> {
            try {
                Thread.sleep(50);
                copyOnWriteList.add("Four");
                copyOnWriteList.add("Five");
                System.out.println("Added Four and Five");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        executor2.shutdown();
        try {
            executor2.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final list: " + copyOnWriteList);
        System.out.println();

        // 3. ArrayBlockingQueue - Bounded blocking queue
        System.out.println("3. ARRAYBLOCKINGQUEUE");
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        
        ExecutorService executor3 = Executors.newFixedThreadPool(2);
        executor3.submit(() -> {
            try {
                blockingQueue.put("Item1");
                blockingQueue.put("Item2");
                blockingQueue.put("Item3");
                System.out.println("Added 3 items");
                blockingQueue.put("Item4"); // Will block until space available
                System.out.println("Added Item4");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        executor3.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Removed: " + blockingQueue.take());
                System.out.println("Removed: " + blockingQueue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        executor3.shutdown();
        try {
            executor3.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Queue size: " + blockingQueue.size());
        System.out.println();

        // 4. ConcurrentLinkedQueue - Lock-free queue
        System.out.println("4. CONCURRENTLINKEDQUEUE");
        ConcurrentLinkedQueue<Integer> concurrentQueue = new ConcurrentLinkedQueue<>();
        
        ExecutorService executor4 = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int value = i;
            executor4.submit(() -> concurrentQueue.offer(value));
        }
        
        executor4.shutdown();
        try {
            executor4.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Queue: " + concurrentQueue);
        System.out.println("Poll: " + concurrentQueue.poll());
        System.out.println("Queue after poll: " + concurrentQueue);
    }
}


