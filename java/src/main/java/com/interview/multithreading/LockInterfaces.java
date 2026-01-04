package com.interview.multithreading;

import java.util.concurrent.locks.*;

/**
 * Lock Interfaces Examples: ReadWriteLock, StampedLock
 */
public class LockInterfaces {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== LOCK INTERFACES EXAMPLES ===\n");
        
        // 1. ReadWriteLock
        System.out.println("1. READWRITELOCK");
        ReadWriteLockExample.example();
        System.out.println();
        
        // 2. StampedLock
        System.out.println("2. STAMPEDLOCK");
        StampedLockExample.example();
    }
}

class ReadWriteLockExample {
    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int value = 0;
    
    static void example() throws InterruptedException {
        // Multiple readers
        for (int i = 0; i < 3; i++) {
            final int id = i;
            new Thread(() -> {
                lock.readLock().lock();
                try {
                    System.out.println("Reader " + id + " reads: " + value);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.readLock().unlock();
                }
            }).start();
        }
        
        Thread.sleep(50);
        
        // Writer
        new Thread(() -> {
            lock.writeLock().lock();
            try {
                value = 100;
                System.out.println("Writer updates value to: " + value);
            } finally {
                lock.writeLock().unlock();
            }
        }).start();
        
        Thread.sleep(500);
    }
}

class StampedLockExample {
    private static StampedLock lock = new StampedLock();
    private static int value = 0;
    
    static void example() {
        // Optimistic read
        long stamp = lock.tryOptimisticRead();
        int currentValue = value;
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                currentValue = value;
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println("Optimistic read: " + currentValue);
        
        // Write lock
        long writeStamp = lock.writeLock();
        try {
            value = 200;
            System.out.println("Write lock - value updated to: " + value);
        } finally {
            lock.unlockWrite(writeStamp);
        }
    }
}

