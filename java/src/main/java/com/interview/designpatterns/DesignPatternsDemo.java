package com.interview.designpatterns;

/**
 * Main class to run all design pattern examples
 */
public class DesignPatternsDemo {
    
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   DESIGN PATTERNS DEMO (15 PATTERNS)");
        System.out.println("=========================================\n");

        SingletonPattern.main(args);
        System.out.println();
        
        FactoryPattern.main(args);
        System.out.println();
        
        BuilderPattern.main(args);
        System.out.println();
        
        ObserverPattern.main(args);
        System.out.println();
        
        StrategyPattern.main(args);
        System.out.println();
        
        DecoratorPattern.main(args);
        System.out.println();
        
        AdapterPattern.main(args);
        System.out.println();
        
        FacadePattern.main(args);
        System.out.println();
        
        ProxyPattern.main(args);
        System.out.println();
        
        TemplateMethodPattern.main(args);
        System.out.println();
        
        CommandPattern.main(args);
        System.out.println();
        
        ChainOfResponsibilityPattern.main(args);
        System.out.println();
        
        StatePattern.main(args);
        System.out.println();
        
        VisitorPattern.main(args);
        System.out.println();
        
        MementoPattern.main(args);
        
        System.out.println("=========================================");
        System.out.println("      END OF DESIGN PATTERNS DEMO");
        System.out.println("=========================================");
    }
}
