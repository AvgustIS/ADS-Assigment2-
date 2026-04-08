package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BillQueueManager {
    private Queue<String> billQueue = new LinkedList<>();

    public void addBill(String billName) {
        billQueue.add(billName);
        System.out.println("The account has been added: " + billName);
    }

    public void processNextBill() {
        if (billQueue.isEmpty()) {
            System.out.println("The invoice queue is empty.");
            return;
        }
        String bill = billQueue.poll();
        System.out.println("Processing: " + bill);
    }

    public void displayQueue() {
        System.out.println("\nPayment queue");
        if (billQueue.isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        int i = 1;
        for (String bill : billQueue) {
            System.out.println(i++ + ". " + bill);
        }
    }
}