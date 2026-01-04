package com.interview.multithreading;

/**
 * ThreadLocal, Volatile, and Deadlock Examples
 */
public class ThreadLocalVolatileDeadlock {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== THREADLOCAL, VOLATILE, DEADLOCK EXAMPLES ===\n");
        
        // 1. ThreadLocal
        System.out.println("1. THREADLOCAL");
        ThreadLocalExample.example();
        System.out.println();
        
        // 2. Volatile
        System.out.println("2. VOLATILE KEYWORD");
        VolatileExample.example();
        System.out.println();
        
        // 3. Deadlock
        System.out.println("3. DEADLOCK EXAMPLE");
        DeadlockExample.example();
    }
}

class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    
    static void example() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            threadLocal.set(1);
            System.out.println("Thread 1 - Value: " + threadLocal.get());
        });
        
        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            System.out.println("Thread 2 - Value: " + threadLocal.get());
        });
        
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        
        System.out.println("Main thread - Value: " + threadLocal.get());
    }
}

class VolatileExample {
    private static volatile boolean flag = false;
    private static int counter = 0;
    
    static void example() throws InterruptedException {
        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(100);
                flag = true;
                System.out.println("Flag set to true");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        
        Thread reader = new Thread(() -> {
            while (!flag) {
                // Busy wait
            }
            System.out.println("Flag is now true, exiting");
        });
        
        reader.start();
        writer.start();
        reader.join();
        writer.join();
    }
}

class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    
    static void example() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock1 and lock2");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock1 and lock2");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        // Wait a bit to see deadlock
        Thread.sleep(500);
        
        System.out.println("Deadlock detected (threads are stuck)");
        System.out.println("Solution: Always acquire locks in same order");
    }
}

