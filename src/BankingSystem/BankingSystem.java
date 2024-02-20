package BankingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingSystem {

    private List<Account> accounts; // List of accounts
    private Map<Integer, Account> accountIndex; // Map to index accounts by account number

    public BankingSystem() {
        accounts = new ArrayList<>();
        accountIndex = new HashMap<>();
    }

    // Add a new account to the system
    public void addAccount(int accountNumber, String name, double initialBalance) {
        Account newAccount = new Account(accountNumber, name, initialBalance);
        accounts.add(newAccount);
        accountIndex.put(accountNumber, newAccount);
    }
    public void deleteAccount(int accountNumber) {
        Account account = accountIndex.get(accountNumber);
        if (account != null) {
            accounts.remove(account);
            accountIndex.remove(accountNumber);
            System.out.println("Account " + accountNumber + " deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }


    // Perform a transaction for a given account
    public void performTransaction(int accountNumber, double amount, String description) {
        Account account = accountIndex.get(accountNumber);
        if (account != null) {
            account.balance += amount;
            account.transactionHistory.add(new Transaction("Today", amount, description));
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display transaction history for a given account
    public void displayTransactionHistory(int accountNumber) {
        Account account = accountIndex.get(accountNumber);
        if (account != null) {
            System.out.println("Transaction history for account " + accountNumber + ":");
            for (Transaction transaction : account.transactionHistory) {
                System.out.println(transaction.date + " - " + transaction.amount + " - " + transaction.description);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display account details
    public void displayAccountDetails(int accountNumber) {
        Account account = accountIndex.get(accountNumber);
        if (account != null) {
            System.out.println("Account number: " + account.accountNumber);
            System.out.println("Name: " + account.name);
            System.out.println("Balance: " + account.balance);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Main method
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding some sample accounts
        bank.addAccount(1001, "John Doe", 5000);
        bank.addAccount(1002, "Jane Smith", 3000);

        // Performing transactions
        bank.performTransaction(1001, -500, "Withdrawal");
        bank.performTransaction(1002, 1000, "Deposit");

        // Displaying account details
        bank.displayAccountDetails(1001);
        bank.displayAccountDetails(1002);

        // Displaying transaction history
        bank.displayTransactionHistory(1001);
        bank.displayTransactionHistory(1002);

        bank.deleteAccount(1001);

        // Displaying account details after deletion
        bank.displayAccountDetails(1001);
    }
}
