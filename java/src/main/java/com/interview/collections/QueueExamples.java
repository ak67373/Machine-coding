package com.interview.collections;

import java.util.*;

/**
 * Queue Examples: PriorityQueue, ArrayDeque, LinkedList
 * Queue follows FIFO (First In First Out) principle
 */
public class QueueExamples {
    
    public static void main(String[] args) {
        System.out.println("=== QUEUE EXAMPLES ===\n");

        // 1. PriorityQueue - Elements ordered by priority (heap)
        System.out.println("1. PRIORITYQUEUE (Heap-based, O(log n))");
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(5);
        System.out.println("PriorityQueue: " + priorityQueue); // May not show sorted
        System.out.println("Peek (smallest): " + priorityQueue.peek());
        System.out.print("Poll all: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " "); // Removes in sorted order
        }
        System.out.println("\n");

        // 2. PriorityQueue with custom comparator (max-heap)
        System.out.println("2. PRIORITYQUEUE (Max-heap)");
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);
        maxHeap.offer(5);
        System.out.print("Poll (descending): ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println("\n");

        // 3. ArrayDeque - Double-ended queue, fast operations
        System.out.println("3. ARRAYDEQUE (Double-ended queue)");
        Deque<String> arrayDeque = new ArrayDeque<>();
        
        // Queue operations (FIFO)
        arrayDeque.offer("First");
        arrayDeque.offer("Second");
        arrayDeque.offer("Third");
        System.out.println("ArrayDeque: " + arrayDeque);
        System.out.println("Peek: " + arrayDeque.peek());
        System.out.println("Poll: " + arrayDeque.poll());
        System.out.println("After poll: " + arrayDeque);
        
        // Stack operations (LIFO)
        arrayDeque.push("NewFirst");
        System.out.println("After push: " + arrayDeque);
        System.out.println("Pop: " + arrayDeque.pop());
        System.out.println();

        // 4. LinkedList as Queue
        System.out.println("4. LINKEDLIST AS QUEUE");
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.offer("Task1");
        linkedListQueue.offer("Task2");
        linkedListQueue.offer("Task3");
        System.out.println("Queue: " + linkedListQueue);
        System.out.println("Process: " + linkedListQueue.poll());
        System.out.println("Process: " + linkedListQueue.poll());
        System.out.println("Remaining: " + linkedListQueue);
        System.out.println();

        // 5. BlockingQueue Example (Producer-Consumer pattern)
        System.out.println("5. BLOCKINGQUEUE (Thread-safe)");
        // Note: BlockingQueue is typically used with threads
        // ArrayBlockingQueue requires capacity
        Queue<Integer> blockingQueue = new ArrayDeque<>(); // Simplified example
        // In real scenario, use: BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        System.out.println("BlockingQueue is commonly used for Producer-Consumer pattern");
    }
}


