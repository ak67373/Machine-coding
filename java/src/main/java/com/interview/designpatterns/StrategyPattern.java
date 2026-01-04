package com.interview.designpatterns;

/**
 * Strategy Pattern
 * Defines a family of algorithms, encapsulates each one, and makes them interchangeable
 */
public class StrategyPattern {
    
    public static void main(String[] args) {
        System.out.println("=== STRATEGY PATTERN ===\n");
        
        ShoppingCart cart = new ShoppingCart();
        
        // Credit Card payment
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100);
        
        // PayPal payment
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(250);
        
        // Crypto payment
        cart.setPaymentStrategy(new CryptoPayment("0x1234..."));
        cart.checkout(500);
    }
}

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Crypto: " + walletAddress);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

