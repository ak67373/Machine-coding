package com.interview.regex;

import java.util.regex.*;

/**
 * Regular Expressions Examples
 */
public class RegexExamples {
    
    public static void main(String[] args) {
        System.out.println("=== REGULAR EXPRESSIONS EXAMPLES ===\n");
        
        // 1. Pattern and Matcher
        System.out.println("1. PATTERN AND MATCHER");
        String text = "The quick brown fox jumps over the lazy dog";
        Pattern pattern = Pattern.compile("fox");
        Matcher matcher = pattern.matcher(text);
        
        if (matcher.find()) {
            System.out.println("Found: " + matcher.group());
            System.out.println("Start: " + matcher.start());
            System.out.println("End: " + matcher.end());
        }
        System.out.println();
        
        // 2. Character Classes
        System.out.println("2. CHARACTER CLASSES");
        String email = "user@example.com";
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher emailMatcher = emailPattern.matcher(email);
        System.out.println("Email valid: " + emailMatcher.matches());
        System.out.println();
        
        // 3. Quantifiers
        System.out.println("3. QUANTIFIERS");
        String numbers = "123 4567 89012";
        Pattern numberPattern = Pattern.compile("\\d{3,4}");
        Matcher numberMatcher = numberPattern.matcher(numbers);
        System.out.println("Numbers:");
        while (numberMatcher.find()) {
            System.out.println("  " + numberMatcher.group());
        }
        System.out.println();
        
        // 4. Groups
        System.out.println("4. GROUPS");
        String phone = "123-456-7890";
        Pattern phonePattern = Pattern.compile("(\\d{3})-(\\d{3})-(\\d{4})");
        Matcher phoneMatcher = phonePattern.matcher(phone);
        if (phoneMatcher.matches()) {
            System.out.println("Full match: " + phoneMatcher.group(0));
            System.out.println("Area code: " + phoneMatcher.group(1));
            System.out.println("Exchange: " + phoneMatcher.group(2));
            System.out.println("Number: " + phoneMatcher.group(3));
        }
        System.out.println();
        
        // 5. String methods with regex
        System.out.println("5. STRING METHODS WITH REGEX");
        String text2 = "Java123Python456JavaScript789";
        String[] parts = text2.split("\\d+");
        System.out.println("Split by digits:");
        for (String part : parts) {
            System.out.println("  " + part);
        }
        
        String replaced = text2.replaceAll("\\d+", "-");
        System.out.println("Replace digits: " + replaced);
        System.out.println();
        
        // 6. Common patterns
        System.out.println("6. COMMON PATTERNS");
        validatePattern("^[A-Za-z0-9+_.-]+@(.+)$", "test@example.com", "Email");
        validatePattern("^\\d{10}$", "1234567890", "10-digit phone");
        validatePattern("^[A-Za-z0-9]{8,}$", "Password123", "Password (8+ chars)");
    }
    
    static void validatePattern(String regex, String input, String description) {
        boolean matches = Pattern.matches(regex, input);
        System.out.println(description + ": " + input + " - " + (matches ? "Valid" : "Invalid"));
    }
}

