import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FinancialSystem {
    private List<Transaction> transactions;
    private Map<String, Integer> debts;
    private Map<String, Integer> moneyOwed;

    public FinancialSystem() {
        transactions = new ArrayList<>();
        debts = new HashMap<>();
        moneyOwed = new HashMap<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        updateDebtsAndMoneyOwed(transaction);
    }

    private void updateDebtsAndMoneyOwed(Transaction transaction) {
        String debtor = transaction.debtor;
        String creditor = transaction.creditor;
        int amount = transaction.amount;

        debts.put(debtor, debts.getOrDefault(debtor, 0) + amount);
        moneyOwed.put(creditor, moneyOwed.getOrDefault(creditor, 0) + amount);
    }

    public int queryDebt(String person) {
        return debts.getOrDefault(person, 0);
    }

    public int queryMoneyOwed(String person) {
        return moneyOwed.getOrDefault(person, 0);
    }

    public String queryPersonWithMostMoneyOwed() {
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
