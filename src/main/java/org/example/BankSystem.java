package org.example;

import org.example.*;
import java.util.Scanner;

public class BankSystem {
    private AccountManager accountManager = new AccountManager();
    private TransactionManager transactionManager = new TransactionManager();
    private BillQueueManager billQueueManager = new BillQueueManager();
    private AccountRequestManager requestManager = new AccountRequestManager();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("=== Banking System Launched ===\n");

        while (true) {
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Task 6: Physical Array");
            System.out.println("5 - Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> bankMenu();
                case 2 -> atmMenu();
                case 3 -> adminMenu();
                case 4 -> task6PhysicalArray();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void bankMenu() {
        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Submit account opening request");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Pay bill");
            System.out.println("5. Back");
            System.out.print("Choose: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1 -> requestManager.addRequest(getUsernameInput());
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> billQueueManager.addBill(getBillName());
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void atmMenu() {
        System.out.println("\n=== ATM Menu ===");
        System.out.println("1. Balance enquiry");
        System.out.println("2. Withdraw");
        System.out.println("3. Back");
        System.out.print("Choose: ");
        int ch = scanner.nextInt();
        scanner.nextLine();

        switch (ch) {
            case 1 -> balanceEnquiry();
            case 2 -> withdraw();
            case 3 -> {}
            default -> System.out.println("Invalid choice!");
        }
    }

    private void adminMenu() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. View account requests queue");
            System.out.println("2. Process next request");
            System.out.println("3. View bill payment queue");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1 -> requestManager.displayRequests();
                case 2 -> requestManager.processNextRequest(accountManager);
                case 3 -> billQueueManager.displayQueue();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void deposit() {
        String user = getUsernameInput();
        System.out.print("Deposit amount: ");
        double amt = scanner.nextDouble();
        scanner.nextLine();
        accountManager.deposit(user, amt);
        transactionManager.addTransaction("Deposit " + amt + " to " + user);
    }

    private void withdraw() {
        String user = getUsernameInput();
        System.out.print("Withdraw amount: ");
        double amt = scanner.nextDouble();
        scanner.nextLine();
        accountManager.withdraw(user, amt);
        transactionManager.addTransaction("Withdraw " + amt + " from " + user);
    }

    private void balanceEnquiry() {
        String user = getUsernameInput();
        BankAccount acc = accountManager.findAccount(user);
        if (acc != null) {
            acc.information();
        } else {
            System.out.println("Account not found!");
        }
    }

    private String getUsernameInput() {
        System.out.print("Enter username: ");
        return scanner.nextLine();
    }

    private String getBillName() {
        System.out.print("Bill name (e.g. Electricity Bill): ");
        return scanner.nextLine();
    }

    private void task6PhysicalArray() {
        System.out.println("\n=== Task 6: Physical Data Structures (Array) ===");
        BankAccount[] array = new BankAccount[3];
        array[0] = new BankAccount("BA1001", "Ali", 150000);
        array[1] = new BankAccount("BA1002", "Sara", 220000);
        array[2] = new BankAccount("BA1003", "Omar", 75000);

        System.out.println("Accounts List:");
        for (int i = 0; i < array.length; i++) {
            System.out.println((i + 1) + ". " + array[i]);
        }
        System.out.println("Task 6 completed successfully!\n");
    }
}