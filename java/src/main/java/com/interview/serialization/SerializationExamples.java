package com.interview.serialization;

import java.io.*;

/**
 * Serialization and Deserialization Examples
 */
public class SerializationExamples {
    
    public static void main(String[] args) {
        System.out.println("=== SERIALIZATION EXAMPLES ===\n");
        
        // Serialize object
        Person person = new Person("Alice", 30, "alice@example.com");
        String filename = "person.ser";
        
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            out.writeObject(person);
            out.close();
            file.close();
            System.out.println("Object serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialize object
        Person deserializedPerson = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            
            deserializedPerson = (Person) in.readObject();
            in.close();
            file.close();
            
            System.out.println("Object deserialized successfully");
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
            System.out.println("Email: " + deserializedPerson.getEmail());
            System.out.println("Transient field (password): " + deserializedPerson.getPassword());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Clean up
        new File(filename).delete();
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private String email;
    private transient String password = "default"; // transient fields are not serialized
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

