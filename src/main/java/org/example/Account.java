package org.example;

public class Account {
    private double balance;

    // Initialisation
    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    //Deposit money sum
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    //Withdraw money sum & lower the balance to match the current sum
    public void withdraw(double amount) {
        if(amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    //Check balance
    public double checkBalance() {
        return balance;
    }

    //Transfer balance to a second account
    public void transfer(double amount, Account account2) {
        if(amount > 0 && balance >= amount) {
            this.withdraw(amount);
            account2.deposit(amount);
        }
    }
}
