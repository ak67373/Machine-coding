package com.interview.enums;

/**
 * Enum Comprehensive Examples
 */
public class EnumExamples {
    
    public static void main(String[] args) {
        System.out.println("=== ENUM EXAMPLES ===\n");
        
        // 1. Basic Enum
        System.out.println("1. BASIC ENUM");
        Day day = Day.MONDAY;
        System.out.println("Day: " + day);
        System.out.println("Name: " + day.name());
        System.out.println("Ordinal: " + day.ordinal());
        System.out.println();
        
        // 2. Enum with methods
        System.out.println("2. ENUM WITH METHODS");
        Size size = Size.MEDIUM;
        System.out.println("Size: " + size);
        System.out.println("Abbreviation: " + size.getAbbreviation());
        System.out.println();
        
        // 3. Enum with constructor
        System.out.println("3. ENUM WITH CONSTRUCTOR");
        Planet earth = Planet.EARTH;
        System.out.println("Planet: " + earth);
        System.out.println("Mass: " + earth.getMass());
        System.out.println("Radius: " + earth.getRadius());
        System.out.println();
        
        // 4. Enum with abstract methods
        System.out.println("4. ENUM WITH ABSTRACT METHODS");
        Operation add = Operation.ADD;
        System.out.println("10 + 5 = " + add.calculate(10, 5));
        System.out.println("10 - 5 = " + Operation.SUBTRACT.calculate(10, 5));
        System.out.println();
        
        // 5. Enum implementing interface
        System.out.println("5. ENUM IMPLEMENTING INTERFACE");
        Color red = Color.RED;
        System.out.println("Color: " + red);
        System.out.println("RGB: " + red.getRGB());
        System.out.println();
        
        // 6. EnumSet and EnumMap
        System.out.println("6. ENUMSET AND ENUMMAP");
        java.util.EnumSet<Day> weekend = java.util.EnumSet.of(Day.SATURDAY, Day.SUNDAY);
        System.out.println("Weekend: " + weekend);
        
        java.util.EnumMap<Day, String> schedule = new java.util.EnumMap<>(Day.class);
        schedule.put(Day.MONDAY, "Work");
        schedule.put(Day.FRIDAY, "Party");
        System.out.println("Schedule: " + schedule);
    }
}

// Basic Enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enum with methods
enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    
    private String abbreviation;
    
    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }
}

// Enum with constructor and fields
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6);
    
    private final double mass;
    private final double radius;
    
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    
    public double getMass() {
        return mass;
    }
    
    public double getRadius() {
        return radius;
    }
}

// Enum with abstract methods
enum Operation {
    ADD {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    };
    
    public abstract int calculate(int a, int b);
}

// Enum implementing interface
interface ColorInterface {
    String getRGB();
}

enum Color implements ColorInterface {
    RED {
        @Override
        public String getRGB() {
            return "255,0,0";
        }
    },
    GREEN {
        @Override
        public String getRGB() {
            return "0,255,0";
        }
    },
    BLUE {
        @Override
        public String getRGB() {
            return "0,0,255";
        }
    };
}

