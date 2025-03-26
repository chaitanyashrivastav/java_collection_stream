import java.util.*;

class BankingSystem {
    private final Map<Integer, Double> accounts = new HashMap<>();  // Stores AccountNumber -> Balance
    private final Queue<Integer> withdrawalQueue = new LinkedList<>();  // Queue for withdrawal requests

    // Create a new account
    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("✅ Account " + accountNumber + " created with balance: $" + initialBalance);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
            System.out.println("💰 Deposited $" + amount + " into Account " + accountNumber);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // Request withdrawal (added to queue)
    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
            System.out.println("📥 Withdrawal request added for Account " + accountNumber);
        } else {
            System.out.println("❌ Account not found!");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);
                System.out.println("✅ Withdrawal of $" + amount + " processed for Account " + accountNumber);
            } else {
                System.out.println("❌ Insufficient funds for Account " + accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
        for (var entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("\n🏦 Accounts Sorted by Balance:");
        for (var entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + " - Balance: $" + entry.getKey());
        }
    }
}

public class BankingSystemDemo {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Create accounts
        bank.createAccount(101, 5000);
        bank.createAccount(102, 3000);
        bank.createAccount(103, 7000);

        // Perform transactions
        bank.deposit(101, 2000);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(103);

        // Process withdrawals
        bank.processWithdrawals(2500);

        // Display sorted accounts
        bank.displaySortedAccounts();
    }
}

