package com.interview.designpatterns;

/**
 * Decorator Pattern
 * Allows behavior to be added to individual objects dynamically
 */
public class DecoratorPattern {
    
    public static void main(String[] args) {
        System.out.println("=== DECORATOR PATTERN ===\n");
        
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $" + simpleCoffee.getCost() + ", Description: " + simpleCoffee.getDescription());
        
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Cost: $" + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());
        
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: $" + sugarMilkCoffee.getCost() + ", Description: " + sugarMilkCoffee.getDescription());
        
        Coffee allDecorations = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));
        System.out.println("Cost: $" + allDecorations.getCost() + ", Description: " + allDecorations.getDescription());
    }
}

interface Coffee {
    double getCost();
    String getDescription();
}

class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 0.2;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }
}

