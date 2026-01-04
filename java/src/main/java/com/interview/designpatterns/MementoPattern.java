package com.interview.designpatterns;

import java.util.*;

/**
 * Memento Pattern
 * Captures and externalizes an object's internal state so it can be restored later
 */
public class MementoPattern {
    
    public static void main(String[] args) {
        System.out.println("=== MEMENTO PATTERN ===\n");
        
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        
        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());
        
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        
        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());
        
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}

