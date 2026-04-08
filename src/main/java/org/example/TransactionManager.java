package org.example;

import java.util.Stack;

public class TransactionManager {
    private Stack<String> history = new Stack<>();

    public void addTransaction(String transaction) {
        history.push(transaction);
        System.out.println("Transaction added: " + transaction);
    }

    public void showLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("The transaction history is empty.");
        } else {
            System.out.println("Last transaction: " + history.peek());
        }
    }

    public void undoLastTransaction() {
        if (history.isEmpty()) {
            System.out.println("There is nothing to cancel.");
        } else {
            System.out.println("Cancelled: " + history.pop());
        }
    }
}