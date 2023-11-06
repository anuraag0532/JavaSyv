import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Transaction {
    String debtor;
    String creditor;
    int amount;

    public Transaction(String debtor, String creditor, int amount) {
        this.debtor = debtor;
        this.creditor = creditor;
        this.amount = amount;
    }
}

class FinancialSystem {
    private List<Transaction> transactions;
    private Map<String, Integer> debts;
    private Map<String, Integer> moneyOwed;

    public FinancialSystem() {
        // Initialize the data structures to store transactions, debts, and money owed.
        transactions = new ArrayList<>();
        debts = new HashMap<>();
        moneyOwed = new HashMap<>();
    }

    public void addTransaction(Transaction transaction) {
        // Add a new transaction and update the debts and money owed.
        transactions.add(transaction);
        updateDebtsAndMoneyOwed(transaction);
    }

    private void updateDebtsAndMoneyOwed(Transaction transaction) {
        // Update debts and money owed based on the transaction details.
        String debtor = transaction.debtor;
        String creditor = transaction.creditor;
        int amount = transaction.amount;

        // Update the debtor's debt and the creditor's money owed.
        debts.put(debtor, debts.getOrDefault(debtor, 0) + amount);
        moneyOwed.put(creditor, moneyOwed.getOrDefault(creditor, 0) + amount);
    }

    public int queryDebt(String person) {
        // Query the debt of a person; return 0 if not found.
        return debts.getOrDefault(person, 0);
    }

    public int queryMoneyOwed(String person) {
        // Query the money owed to a person; return 0 if not found.
        return moneyOwed.getOrDefault(person, 0);
    }

    public String queryPersonWithMostMoneyOwed() {
        // Find the person with the most money owed and return their name.
        String person = null;
        int maxMoneyOwed = 0;

        for (Map.Entry<String, Integer> entry : moneyOwed.entrySet()) {
            if (entry.getValue() > maxMoneyOwed) {
                person = entry.getKey();
                maxMoneyOwed = entry.getValue();
            }
        }

        return person;
    }

    public String queryPersonWithMostDebt() {
        // Find the person with the most debt and return their name.
        String person = null;
        int maxDebt = 0;

        for (Map.Entry<String, Integer> entry : debts.entrySet()) {
            if (entry.getValue() > maxDebt) {
                person = entry.getKey();
                maxDebt = entry.getValue();
            }
        }

        return person;
    }
}
