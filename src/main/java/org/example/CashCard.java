package org.example;

public class CashCard {
    private Long id;
    private double balance;

    public CashCard(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}

