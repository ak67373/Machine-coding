package com.interview.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Producer-Consumer Pattern using BlockingQueue
 * Demonstrates inter-thread communication
 */
public class ProducerConsumerExample {
    
    public static void main(String[] args) {
        System.out.println("=== PRODUCER-CONSUMER PATTERN ===\n");

        // BlockingQueue is thread-safe
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        
        // Producer thread
        Thread producer = new Thread(new Producer(queue), "Producer");
        
        // Consumer thread
        Thread consumer = new Thread(new Consumer(queue), "Consumer");
        
        producer.start();
        consumer.start();
        
        try {
            Thread.sleep(5000); // Run for 5 seconds
            producer.interrupt();
            consumer.interrupt();
            
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nProducer-Consumer example completed");
    }
}

/**
 * Producer class that adds items to the queue
 */
class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(value); // Blocking operation
                System.out.println(Thread.currentThread().getName() + " produced: " + value);
                value++;
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * Consumer class that removes items from the queue
 */
class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Integer value = queue.take(); // Blocking operation
                System.out.println(Thread.currentThread().getName() + " consumed: " + value);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


