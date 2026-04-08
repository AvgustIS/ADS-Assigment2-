package org.example;


import java.util.LinkedList;

public class AccountManager {
    private LinkedList<BankAccount> accounts = new LinkedList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account added successfully!");
    }

    public void displayAllAccounts() {
        System.out.println("\nList of all accounts");
        if (accounts.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        int i = 1;
        for (BankAccount acc : accounts) {
            System.out.println(i++ + ". " + acc);
        }
    }

    public BankAccount findAccount(String username) {
        for (BankAccount acc : accounts) {
            if (acc.getUsername().equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }

    public void deposit(String username, double amount) {
        BankAccount acc = findAccount(username);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        acc.deposit(amount);
        System.out.println("The deposit has been completed. New balance.: " + acc.getBalance());
    }

    public void withdraw(String username, double amount) {
        BankAccount acc = findAccount(username);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }
        if (acc.withdraw(amount)) {
            System.out.println("Withdrawal completed. New balance.: " + acc.getBalance());
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public LinkedList<BankAccount> getAccounts() {
        return accounts;
    }
}