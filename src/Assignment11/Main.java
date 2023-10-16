package Assignment11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Customer> customers = new HashMap<>();
        List<BankAccount> accounts = new ArrayList<>();
        int accountNumberCounter = 1000;

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Create Customer");
            System.out.println("2. Open Bank Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter customer ID: ");
                    int customerID = scanner.nextInt();
                    if (customers.containsKey(customerID)) {
                        System.out.println("Customer with the provided ID already exists.");
                    } else {
                        customers.put(customerID, new Customer(name, customerID));
                        System.out.println("Customer created successfully!");
                    }
                    break;

                case 2:
                    if (customers.isEmpty()) {
                        System.out.println("No customers found. Please create a customer first.");
                    } else {
                        System.out.print("Enter customer ID for account creation: ");
                        int selectedCustomerID = scanner.nextInt();
                        if (customers.containsKey(selectedCustomerID)) {
                            Customer selectedCustomer = customers.get(selectedCustomerID);
                            System.out.print("Enter initial balance for the account: ");
                            double initialBalance = scanner.nextDouble();
                            String accountNumber = "ACC" + (accountNumberCounter++);
                            accounts.add(new BankAccount(selectedCustomer, accountNumber, initialBalance));
                            System.out.println("Account created successfully! " + accountNumber);
                        } else {
                            System.out.println("Customer not found with the provided ID.");
                        }
                    }
                    break;

                case 3:
                    deposit(accounts, scanner);
                    break;

                case 4:
                    withdraw(accounts, scanner);
                    break;

                case 5:
                    balanceCheck(accounts, scanner);
                    break;

                case 6:
                    System.out.println("Exiting the Bank Account Management System.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }
        }
    }

    private static void deposit(List<BankAccount> accounts, Scanner scanner) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please open an account first.");
            return;
        }

        System.out.print("Enter account number for the deposit: ");
        String selectedAccountNumber = scanner.nextLine();
        BankAccount selectedAccount = null;

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(selectedAccountNumber)) {
                selectedAccount = account;
                break;
            }
        }

        if (selectedAccount != null) {
            System.out.print("Enter the deposit amount: ");
            double amount = scanner.nextDouble();
            selectedAccount.deposit(amount);
        } else {
            System.out.println("Account not found with the provided account number.");
        }
    }

    private static void withdraw(List<BankAccount> accounts, Scanner scanner) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please open an account first.");
            return;
        }

        System.out.print("Enter account number for the withdrawal: ");
        String selectedAccountNumber = scanner.nextLine();
        BankAccount selectedAccount = null;

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(selectedAccountNumber)) {
                selectedAccount = account;
                break;
            }
        }

        if (selectedAccount != null) {
            System.out.print("Enter the withdrawal amount: ");
            double amount = scanner.nextDouble();
            selectedAccount.withdraw(amount);
        } else {
            System.out.println("Account not found with the provided account number.");
        }
    }

    private static void balanceCheck(List<BankAccount> accounts, Scanner scanner) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please open an account first.");
            return;
        }

        System.out.print("Enter account number for balance inquiry: ");
        String selectedAccountNumber = scanner.nextLine();
        BankAccount selectedAccount = null;

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(selectedAccountNumber)) {
                selectedAccount = account;
                break;
            }
        }

        if (selectedAccount != null) {
            selectedAccount.checkBalance();
        } else {
            System.out.println("Account not found with the provided account number.");
        }
    }
}


