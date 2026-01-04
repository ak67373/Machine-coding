package com.interview.designpatterns;

/**
 * Proxy Pattern
 * Provides a surrogate or placeholder for another object to control access to it
 */
public class ProxyPattern {
    
    public static void main(String[] args) {
        System.out.println("=== PROXY PATTERN ===\n");
        
        Image image1 = new ProxyImage("test1.jpg");
        Image image2 = new ProxyImage("test2.jpg");
        
        // Image will be loaded from disk
        image1.display();
        System.out.println();
        
        // Image will not be loaded from disk (already loaded)
        image1.display();
        System.out.println();
        
        image2.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName + " from disk");
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}

