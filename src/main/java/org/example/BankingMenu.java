package org.example;

import java.util.*;

public class BankingMenu {
    private static LinkedList<BankAccount> accounts = new LinkedList<>();
    private static Stack<String> transactionHistory = new Stack<>();
    private static Queue<String> billQueue = new LinkedList<>();
    private static Queue<BankAccount> accountRequests = new LinkedList<>();
    private static int accountCounter = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Banking System");

        while (true) {
            System.out.println("\n1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Physical Array");
            System.out.println("5 - Exit");
            System.out.print("Choose one: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            boolean backToMain = false;

            switch (choice) {
                case 1: bankMenu(scanner); break;
                case 2: atmMenu(scanner); break;
                case 3: adminMenu(scanner); break;
                case 4: runPhysicalArrayDemo(); break;
                case 5:
                    System.out.println("Good Bye!");
                    scanner.close();
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void bankMenu(Scanner sc) {
        while (true) {
            System.out.println("\nBank Menu");
            System.out.println("1. Submit account opening request");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Pay bill");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose one: ");
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1: submitRequest(sc); break;
                case 2: deposit(sc); break;
                case 3: withdraw(sc); break;
                case 4: payBill(sc); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }


    private static void atmMenu(Scanner sc) {
        System.out.println("\n1. Balance enquiry");
        System.out.println("2. Withdraw");
        System.out.println("3. Back to Menu");
        System.out.print("Choose one: ");
        int num = sc.nextInt();
        sc.nextLine();

        switch (num) {
            case 1: balanceEnquiry(sc); break;
            case 2: withdraw(sc); break;
            case 3: return;
            default: System.out.println("Invalid choice!");
        }
    }


    private static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. View account queue");
            System.out.println("2. Process account queue");
            System.out.println("3. View bill payment queue");
            System.out.println("4. Back to Menu");
            System.out.print("Choose one: ");
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1: viewAccountQueue(); break;
                case 2: processAccountQueue(); break;
                case 3: viewBillQueue(); break;
                case 4: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void submitRequest(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        BankAccount req = new BankAccount("BA" + accountCounter++, user, 0);
        accountRequests.add(req);
        System.out.println("Account request added successfully to the queue\n");
    }

    private static void deposit(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        BankAccount acc = findAccount(user);
        if (acc == null) { System.out.println("Username not found!\n"); return; }

        System.out.print("Deposit: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        acc.deposit(amt);
        transactionHistory.push("Deposit " + amt + " to " + user);
        System.out.println("New balance: " + acc.getBalance() + "\n");
    }

    private static void withdraw(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        BankAccount acc = findAccount(user);
        if (acc == null) { System.out.println("Username not found!\n"); return; }

        System.out.print("Withdraw: ");
        double amt = sc.nextDouble();
        sc.nextLine();
        if (acc.withdraw(amt)) {
            transactionHistory.push("Withdraw " + amt + " from " + user);
            System.out.println("New balance: " + acc.getBalance() + "\n");
        } else {
            System.out.println("Not enough money!\n");
        }
    }

    private static void payBill(Scanner sc) {
        System.out.print("Enter bill name: ");
        String bill = sc.nextLine();
        billQueue.add(bill);
        System.out.println("Added: " + bill + "\n");
    }

    private static void balanceEnquiry(Scanner sc) {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        BankAccount acc = findAccount(user);
        if (acc != null) acc.information();
        else System.out.println("Not found\n");
    }

    private static BankAccount findAccount(String username) {
        for (BankAccount a : accounts) {
            if (a.getUsername().equals(username)) return a;
        }
        return null;
    }

    private static void viewAccountQueue() {
        System.out.println("Account Requests:");
        int i = 1;
        for (BankAccount req : accountRequests) {
            System.out.print(i++ + ". ");
            req.information();
        }
        if (accountRequests.isEmpty()) System.out.println("No request found!");
        System.out.println();
    }

    private static void processAccountQueue() {
        if (accountRequests.isEmpty()) {
            System.out.println("No request found!\n");
            return;
        }
        BankAccount processed = accountRequests.poll();
        accounts.add(processed);
        System.out.println("Processed: " + processed.getUsername() + " added to main accounts\n");
    }

    private static void viewBillQueue() {
        System.out.println("Bill Payment Queue:");
        int i = 1;
        for (String b : billQueue) {
            System.out.println(i++ + ". " + b);
        }
        if (billQueue.isEmpty()) System.out.println("No bill payment found!");
        System.out.println();
    }

    private static void runPhysicalArrayDemo() {
        Main.main(null);
    }
}
