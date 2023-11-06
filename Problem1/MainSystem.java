package Problem1;

import java.util.Scanner;

public class MainSystem {
    public static void main(String[] args) {
        FinancialSystem financialSystem = new FinancialSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            // Check the user's command and perform the corresponding action.
            if (parts[0].equals("add_transaction")) {
                if (parts.length == 4) {
                    // Parse the input and create a new transaction object.
                    Transaction transaction = new Transaction(parts[1], parts[2], Integer.parseInt(parts[3]));
                    financialSystem.addTransaction(transaction);
                }
            } else if (parts[0].equals("query_debt")) {
                if (parts.length == 2) {
                    // Query and print the debt of a specific person.
                    String person = parts[1];
                    int debt = financialSystem.queryDebt(person);
                    System.out.println(person + " owes a total of " + debt + " money.");
                }
            } else if (parts[0].equals("query_money_owed")) {
                if (parts.length == 2) {
                    // Query and print the money owed to a specific person.
                    String person = parts[1];
                    int moneyOwed = financialSystem.queryMoneyOwed(person);
                    System.out.println(person + " is owed a total of " + moneyOwed + " money.");
                }
            } else if (parts[0].equals("query_person_with_most_money_owed")) {
                // Query and print the person owed the most money.
                String person = financialSystem.queryPersonWithMostMoneyOwed();
                System.out.println(person + " is owed the most money.");
            } else if (parts[0].equals("query_person_with_most_debt")) {
                // Query and print the person with the most debt.
                String person = financialSystem.queryPersonWithMostDebt();
                System.out.println(person + " owes the most money.");
            } else {
                // Handle invalid commands and prompt the user to try again.
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
