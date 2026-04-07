package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Physical Data Structures");
        BankAccount[] accountsArray = new BankAccount[3];

        accountsArray[0] = new BankAccount("BA1001", "Ali", 150000);
        accountsArray[1] = new BankAccount("BA1002", "Sara", 220000);
        accountsArray[2] = new BankAccount("BA1003", "Omar", 75000);

        System.out.println("Accounts List:");
        for (int i = 0; i < accountsArray.length; i++) {
            System.out.println((i + 1) + ". " + accountsArray[i].getUsername() +
                    " – Balance: " + accountsArray[i].getBalance());
        }

    }
}