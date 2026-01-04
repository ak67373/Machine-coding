package com.interview.multithreading;

/**
 * Synchronization Examples:
 * 1. Synchronized methods
 * 2. Synchronized blocks
 * 3. Static synchronization
 * 4. ReentrantLock
 */
public class SynchronizationExample {
    
    public static void main(String[] args) {
        System.out.println("=== SYNCHRONIZATION EXAMPLES ===\n");

        // 1. Synchronized Method
        System.out.println("1. SYNCHRONIZED METHOD");
        Counter counter1 = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter1.increment();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter value (should be 2000): " + counter1.getCount());
        System.out.println();

        // 2. Synchronized Block
        System.out.println("2. SYNCHRONIZED BLOCK");
        Counter counter2 = new Counter();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.incrementWithBlock();
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter2.incrementWithBlock();
            }
        });
        
        t3.start();
        t4.start();
        
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter value (should be 2000): " + counter2.getCount());
        System.out.println();

        // 3. Static Synchronization
        System.out.println("3. STATIC SYNCHRONIZATION");
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter.incrementStatic();
            }
        });
        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Counter.incrementStatic();
            }
        });
        
        t5.start();
        t6.start();
        
        try {
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Static counter value (should be 2000): " + Counter.getStaticCount());
        System.out.println();

        // 4. ReentrantLock
        System.out.println("4. REENTRANTLOCK");
        CounterWithLock counter3 = new CounterWithLock();
        Thread t7 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter3.increment();
            }
        });
        Thread t8 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter3.increment();
            }
        });
        
        t7.start();
        t8.start();
        
        try {
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter with Lock value (should be 2000): " + counter3.getCount());
    }
}

/**
 * Counter with synchronized method
 */
class Counter {
    private int count = 0;
    private static int staticCount = 0;
    private final Object lock = new Object();

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    // Synchronized block
    public void incrementWithBlock() {
        synchronized (lock) {
            count++;
        }
    }

    // Static synchronized method
    public static synchronized void incrementStatic() {
        staticCount++;
    }

    public int getCount() {
        return count;
    }

    public static int getStaticCount() {
        return staticCount;
    }
}

/**
 * Counter using ReentrantLock
 */
class CounterWithLock {
    private int count = 0;
    private final java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire lock
        try {
            count++;
        } finally {
            lock.unlock(); // Always release lock in finally block
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}


