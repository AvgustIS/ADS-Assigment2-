package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class AccountRequestManager {
    private Queue<BankAccount> requests = new LinkedList<>();
    private int accountCounter = 1000;

    public void addRequest(String username) {
        String accNum = "BA" + accountCounter++;
        BankAccount newAccount = new BankAccount(accNum, username, 0.0);
        requests.add(newAccount);
        System.out.println("Request to open an account for " + username + " added to the queue.");
    }

    public void processNextRequest(AccountManager accountManager) {
        if (requests.isEmpty()) {
            System.out.println("There are no requests to open accounts.");
            return;
        }
        BankAccount processed = requests.poll();
        accountManager.addAccount(processed);  // передаём в основной LinkedList
        System.out.println("Request processed. Invoice " + processed.getUsername() + " added to the database.");
    }

    public void displayRequests() {
        System.out.println("\nAccount opening request queue");
        if (requests.isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        int i = 1;
        for (BankAccount req : requests) {
            System.out.println(i++ + ". " + req.getUsername());
        }
    }
}