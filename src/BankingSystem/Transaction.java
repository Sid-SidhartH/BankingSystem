package BankingSystem;

class Transaction {

    String date;
    double amount;
    String description;

    Transaction(String date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
}
