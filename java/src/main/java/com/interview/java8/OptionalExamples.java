package com.interview.java8;

import java.util.Optional;

/**
 * Optional Examples
 * Optional helps avoid NullPointerException
 */
public class OptionalExamples {
    
    public static void main(String[] args) {
        System.out.println("=== OPTIONAL EXAMPLES ===\n");

        // 1. Creating Optional
        System.out.println("1. CREATING OPTIONAL");
        Optional<String> empty = Optional.empty();
        Optional<String> ofValue = Optional.of("Hello");
        Optional<String> ofNullable = Optional.ofNullable(null);
        Optional<String> ofNullableValue = Optional.ofNullable("World");
        
        System.out.println("Empty: " + empty);
        System.out.println("Of value: " + ofValue);
        System.out.println("Of nullable (null): " + ofNullable);
        System.out.println("Of nullable (value): " + ofNullableValue);
        System.out.println();

        // 2. Checking if value is present
        System.out.println("2. CHECKING PRESENCE");
        System.out.println("Empty isPresent: " + empty.isPresent());
        System.out.println("OfValue isPresent: " + ofValue.isPresent());
        System.out.println("Empty isEmpty: " + empty.isEmpty()); // Java 11+
        System.out.println();

        // 3. Getting values
        System.out.println("3. GETTING VALUES");
        if (ofValue.isPresent()) {
            System.out.println("Value: " + ofValue.get());
        }
        
        System.out.println("OrElse: " + empty.orElse("Default"));
        System.out.println("OrElseGet: " + empty.orElseGet(() -> "Default from supplier"));
        System.out.println();

        // 4. Map and FlatMap
        System.out.println("4. MAP AND FLATMAP");
        Optional<String> upperCase = ofValue.map(String::toUpperCase);
        System.out.println("Mapped to uppercase: " + upperCase.orElse("Empty"));
        
        Optional<Integer> length = ofValue.map(String::length);
        System.out.println("Length: " + length.orElse(0));
        System.out.println();

        // 5. Filter
        System.out.println("5. FILTER");
        Optional<String> filtered = ofValue.filter(s -> s.length() > 3);
        System.out.println("Filtered (>3 chars): " + filtered.orElse("Not found"));
        
        Optional<String> filteredEmpty = ofValue.filter(s -> s.length() > 10);
        System.out.println("Filtered (>10 chars): " + filteredEmpty.orElse("Not found"));
        System.out.println();

        // 6. ifPresent and ifPresentOrElse
        System.out.println("6. IFPRESENT");
        ofValue.ifPresent(value -> System.out.println("Value exists: " + value));
        empty.ifPresent(value -> System.out.println("This won't print"));
        
        // ifPresentOrElse (Java 9+)
        empty.ifPresentOrElse(
                value -> System.out.println("Value: " + value),
                () -> System.out.println("No value present")
        );
        System.out.println();

        // 7. orElseThrow
        System.out.println("7. ORELSE THROW");
        try {
            String value = ofValue.orElseThrow();
            System.out.println("Value: " + value);
            
            empty.orElseThrow(() -> new RuntimeException("No value"));
            System.out.println("This won't print");
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        System.out.println();

        // 8. Practical Example
        System.out.println("8. PRACTICAL EXAMPLE");
        User user = new User("Alice", "alice@example.com");
        Optional<User> userOptional = Optional.of(user);
        
        String email = userOptional
                .map(User::getEmail)
                .filter(e -> e.contains("@"))
                .orElse("invalid@email.com");
        System.out.println("Email: " + email);
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

