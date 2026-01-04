package com.interview.multithreading;

/**
 * Different ways to create threads:
 * 1. Extending Thread class
 * 2. Implementing Runnable interface
 * 3. Using Lambda expressions
 */
public class ThreadCreationExample {
    
    public static void main(String[] args) {
        System.out.println("=== THREAD CREATION METHODS ===\n");

        // Method 1: Extending Thread class
        System.out.println("1. EXTENDING THREAD CLASS");
        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");
        thread1.start(); // Start thread
        thread2.start();
        
        try {
            thread1.join(); // Wait for thread1 to finish
            thread2.join(); // Wait for thread2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // Method 2: Implementing Runnable interface
        System.out.println("2. IMPLEMENTING RUNNABLE INTERFACE");
        Thread thread3 = new Thread(new MyRunnable("Runnable-1"));
        Thread thread4 = new Thread(new MyRunnable("Runnable-2"));
        thread3.start();
        thread4.start();
        
        try {
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // Method 3: Using Lambda expression
        System.out.println("3. USING LAMBDA EXPRESSION");
        Thread thread5 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Lambda-Thread");
        thread5.start();
        
        try {
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        // Thread states
        System.out.println("4. THREAD STATES");
        Thread thread6 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "State-Thread");
        
        System.out.println("State before start: " + thread6.getState()); // NEW
        thread6.start();
        System.out.println("State after start: " + thread6.getState()); // RUNNABLE
        
        try {
            Thread.sleep(100);
            System.out.println("State while running: " + thread6.getState()); // TIMED_WAITING
            thread6.join();
            System.out.println("State after completion: " + thread6.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Method 1: Extending Thread class
 */
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * Method 2: Implementing Runnable interface
 */
class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " (" + name + "): " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


