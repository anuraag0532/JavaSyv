package Problem1;

public class Transaction {
    String debtor;
    String creditor;
    int amount;

    public Transaction(String debtor, String creditor, int amount) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.amount = amount;
    }
} 