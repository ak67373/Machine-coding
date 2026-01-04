package com.interview.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 8 Stream API Examples
 * Streams provide functional-style operations on collections
 */
public class StreamExamples {
    
    public static void main(String[] args) {
        System.out.println("=== JAVA 8 STREAM API EXAMPLES ===\n");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Alice");

        // 1. Filter - Filter elements based on predicate
        System.out.println("1. FILTER - Filter even numbers");
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println();

        // 2. Map - Transform each element
        System.out.println("2. MAP - Square each number");
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
        System.out.println();

        // 3. Distinct - Remove duplicates
        System.out.println("3. DISTINCT - Remove duplicate names");
        List<String> uniqueNames = names.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique names: " + uniqueNames);
        System.out.println();

        // 4. Sorted - Sort elements
        System.out.println("4. SORTED - Sort names in reverse order");
        List<String> sortedNames = names.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted names (reverse): " + sortedNames);
        System.out.println();

        // 5. Limit and Skip - Limit or skip elements
        System.out.println("5. LIMIT AND SKIP - Get first 3 numbers after skipping 2");
        List<Integer> limited = numbers.stream()
                .skip(2)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Limited: " + limited);
        System.out.println();

        // 6. forEach - Perform action on each element
        System.out.println("6. FOREACH - Print each number");
        System.out.print("Numbers: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println("\n");

        // 7. Collect - Collect stream to Collection
        System.out.println("7. COLLECT - Collect to different collections");
        Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("Set: " + numberSet);
        
        Map<String, Integer> nameLengthMap = names.stream()
                .distinct()
                .collect(Collectors.toMap(name -> name, String::length));
        System.out.println("Name-Length Map: " + nameLengthMap);
        System.out.println();

        // 8. Reduce - Reduce stream to single value
        System.out.println("8. REDUCE - Sum all numbers");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Max: " + max.orElse(0));
        System.out.println();

        // 9. anyMatch, allMatch, noneMatch - Match predicates
        System.out.println("9. MATCHING - Check conditions");
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("Has even: " + hasEven);
        System.out.println("All positive: " + allPositive);
        System.out.println("None negative: " + noneNegative);
        System.out.println();

        // 10. findFirst, findAny - Find elements
        System.out.println("10. FIND - Find elements");
        Optional<Integer> firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println("First even: " + firstEven.orElse(-1));
        System.out.println();

        // 11. flatMap - Flatten nested collections
        System.out.println("11. FLATMAP - Flatten nested lists");
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flattened = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened);
        System.out.println();

        // 12. Grouping and Partitioning
        System.out.println("12. GROUPING - Group by condition");
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned (even/odd): " + partitioned);
        
        Map<Integer, List<String>> groupedByLength = names.stream()
                .distinct()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);
        System.out.println();

        // 13. Parallel Streams
        System.out.println("13. PARALLEL STREAMS - Process in parallel");
        long startTime = System.currentTimeMillis();
        List<Integer> parallelProcessed = numbers.parallelStream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("Parallel processed: " + parallelProcessed);
        System.out.println("Parallel time: " + parallelTime + "ms");
        System.out.println();

        // 14. Stream Operations on Map
        System.out.println("14. STREAM ON MAP - Process Map entries");
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        
        map.entrySet().stream()
                .filter(entry -> entry.getValue() > 25)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

