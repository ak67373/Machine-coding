package com.interview.designpatterns;

import java.util.*;

/**
 * Observer Pattern
 * Defines a one-to-many dependency between objects
 */
public class ObserverPattern {
    
    public static void main(String[] args) {
        System.out.println("=== OBSERVER PATTERN ===\n");
        
        Subject subject = new NewsAgency();
        Observer observer1 = new NewsChannel("CNN");
        Observer observer2 = new NewsChannel("BBC");
        Observer observer3 = new NewsChannel("FOX");
        
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.addObserver(observer3);
        
        subject.setNews("Breaking: Java 21 Released!");
        System.out.println();
        
        subject.removeObserver(observer2);
        subject.setNews("Update: Java 21 Features Announced");
    }
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setNews(String news);
}

interface Observer {
    void update(String news);
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    @Override
    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received: " + news);
    }
}

