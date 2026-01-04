package com.interview.designpatterns;

/**
 * Builder Pattern Examples
 * Constructs complex objects step by step
 */
public class BuilderPattern {
    
    public static void main(String[] args) {
        System.out.println("=== BUILDER PATTERN EXAMPLES ===\n");

        // 1. Classic Builder Pattern
        System.out.println("1. CLASSIC BUILDER PATTERN");
        User user = new User.UserBuilder("John", "Doe")
                .age(30)
                .email("john@example.com")
                .phone("123-456-7890")
                .address("123 Main St")
                .build();
        System.out.println(user);
        System.out.println();

        // 2. Fluent Builder
        System.out.println("2. FLUENT BUILDER");
        Pizza pizza = new Pizza.Builder()
                .setSize("Large")
                .setCrust("Thin")
                .addTopping("Cheese")
                .addTopping("Pepperoni")
                .addTopping("Mushrooms")
                .build();
        System.out.println(pizza);
        System.out.println();

        // 3. StringBuilder Example (Built-in Builder)
        System.out.println("3. STRINGBUILDER (Built-in Builder)");
        StringBuilder sb = new StringBuilder();
        String result = sb.append("Hello")
                .append(" ")
                .append("World")
                .append("!")
                .toString();
        System.out.println(result);
    }
}

/**
 * Classic Builder Pattern
 */
class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String phone;
    private final String address;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String email;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{firstName='" + firstName + "', lastName='" + lastName +
                "', age=" + age + ", email='" + email + "', phone='" + phone +
                "', address='" + address + "'}";
    }
}

/**
 * Fluent Builder Pattern
 */
class Pizza {
    private final String size;
    private final String crust;
    private final java.util.List<String> toppings;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.toppings = new java.util.ArrayList<>(builder.toppings);
    }

    public static class Builder {
        private String size = "Medium";
        private String crust = "Regular";
        private java.util.List<String> toppings = new java.util.ArrayList<>();

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setCrust(String crust) {
            this.crust = crust;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        return "Pizza{size='" + size + "', crust='" + crust + 
                "', toppings=" + toppings + "}";
    }
}

