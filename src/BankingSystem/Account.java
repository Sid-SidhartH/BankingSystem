package BankingSystem;

import java.util.ArrayList;
import java.util.List;

class Account {
    int accountNumber;
    String name;
    double balance;
    List<Transaction> transactionHistory;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }
}
