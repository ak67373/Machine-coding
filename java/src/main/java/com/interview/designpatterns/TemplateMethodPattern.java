package com.interview.designpatterns;

/**
 * Template Method Pattern
 * Defines the skeleton of an algorithm in a method, deferring some steps to subclasses
 */
public class TemplateMethodPattern {
    
    public static void main(String[] args) {
        System.out.println("=== TEMPLATE METHOD PATTERN ===\n");
        
        Game game1 = new Cricket();
        game1.play();
        System.out.println();
        
        Game game2 = new Football();
        game2.play();
    }
}

abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // Template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

