package com.interview.reflection;

import java.lang.reflect.*;

/**
 * Reflection API Examples
 * Reflection allows runtime inspection and manipulation of classes
 */
public class ReflectionExamples {
    
    public static void main(String[] args) throws Exception {
        System.out.println("=== REFLECTION API EXAMPLES ===\n");

        // 1. Get Class object
        System.out.println("1. GET CLASS OBJECT");
        Class<?> clazz = Person.class;
        System.out.println("Class name: " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println();

        // 2. Create instance using reflection
        System.out.println("2. CREATE INSTANCE");
        Person person = (Person) clazz.getDeclaredConstructor(String.class, int.class)
                .newInstance("Alice", 30);
        System.out.println("Created person: " + person);
        System.out.println();

        // 3. Get fields
        System.out.println("3. GET FIELDS");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName() + " (" + field.getType() + ")");
        }
        System.out.println();

        // 4. Access private fields
        System.out.println("4. ACCESS PRIVATE FIELDS");
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true); // Make accessible
        nameField.set(person, "Bob");
        System.out.println("Modified name: " + person.getName());
        System.out.println();

        // 5. Get methods
        System.out.println("5. GET METHODS");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName() + 
                    " (" + method.getReturnType() + ")");
        }
        System.out.println();

        // 6. Invoke methods
        System.out.println("6. INVOKE METHODS");
        Method getNameMethod = clazz.getDeclaredMethod("getName");
        String name = (String) getNameMethod.invoke(person);
        System.out.println("Invoked getName(): " + name);
        
        Method setAgeMethod = clazz.getDeclaredMethod("setAge", int.class);
        setAgeMethod.invoke(person, 35);
        System.out.println("Invoked setAge(35), new age: " + person.getAge());
        System.out.println();

        // 7. Get constructors
        System.out.println("7. GET CONSTRUCTORS");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor);
        }
        System.out.println();

        // 8. Get annotations
        System.out.println("8. GET ANNOTATIONS");
        java.lang.annotation.Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (java.lang.annotation.Annotation annotation : annotations) {
            System.out.println("Annotation: " + annotation);
        }
        System.out.println();
    }
}

@Deprecated
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

