package com.interview.designpatterns;

/**
 * Singleton Pattern Examples
 * Ensures only one instance of a class exists
 */
public class SingletonPattern {
    
    public static void main(String[] args) {
        System.out.println("=== SINGLETON PATTERN EXAMPLES ===\n");

        // 1. Eager Initialization
        System.out.println("1. EAGER INITIALIZATION");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("Same instance? " + (eager1 == eager2));
        System.out.println();

        // 2. Lazy Initialization
        System.out.println("2. LAZY INITIALIZATION");
        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("Same instance? " + (lazy1 == lazy2));
        System.out.println();

        // 3. Thread-Safe Singleton (Synchronized)
        System.out.println("3. THREAD-SAFE SINGLETON (Synchronized)");
        ThreadSafeSingleton ts1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton ts2 = ThreadSafeSingleton.getInstance();
        System.out.println("Same instance? " + (ts1 == ts2));
        System.out.println();

        // 4. Double-Checked Locking
        System.out.println("4. DOUBLE-CHECKED LOCKING");
        DoubleCheckedSingleton dc1 = DoubleCheckedSingleton.getInstance();
        DoubleCheckedSingleton dc2 = DoubleCheckedSingleton.getInstance();
        System.out.println("Same instance? " + (dc1 == dc2));
        System.out.println();

        // 5. Bill Pugh Singleton (Inner Static Class)
        System.out.println("5. BILL PUGH SINGLETON (Recommended)");
        BillPughSingleton bp1 = BillPughSingleton.getInstance();
        BillPughSingleton bp2 = BillPughSingleton.getInstance();
        System.out.println("Same instance? " + (bp1 == bp2));
        System.out.println();

        // 6. Enum Singleton (Best for serialization)
        System.out.println("6. ENUM SINGLETON (Best practice)");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("Same instance? " + (enum1 == enum2));
        enum1.showMessage();
        System.out.println();
    }
}

/**
 * Eager Initialization - Instance created at class loading time
 */
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // Private constructor to prevent instantiation
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

/**
 * Lazy Initialization - Instance created on first access (NOT thread-safe)
 */
class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * Thread-Safe Singleton using synchronized method
 */
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

/**
 * Double-Checked Locking - Thread-safe with better performance
 */
class DoubleCheckedSingleton {
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}

/**
 * Bill Pugh Singleton - Thread-safe without synchronization
 * Uses inner static class for lazy initialization
 */
class BillPughSingleton {
    private BillPughSingleton() {
    }

    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

/**
 * Enum Singleton - Best practice, automatically thread-safe and serializable
 */
enum EnumSingleton {
    INSTANCE;

    public void showMessage() {
        System.out.println("Enum Singleton instance");
    }
}

