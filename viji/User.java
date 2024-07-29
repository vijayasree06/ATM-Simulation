import java.util.ArrayList;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private double dailyWithdrawalLimit;
    private double dailyWithdrawnAmount;
    private ArrayList<Transaction> transactionHistory;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.dailyWithdrawalLimit = 500.0; 
        this.dailyWithdrawnAmount = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean checkPin(String pin) {
        return this.pin.equals(pin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction(TransactionType.DEPOSIT, amount));
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            if ((dailyWithdrawnAmount + amount) <= dailyWithdrawalLimit) {
                balance -= amount;
                dailyWithdrawnAmount += amount;
                transactionHistory.add(new Transaction(TransactionType.WITHDRAW, amount));
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Daily withdrawal limit exceeded.");
            }
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void transfer(User recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            transactionHistory.add(new Transaction(TransactionType.TRANSFER, amount, recipient.getUserId()));
            recipient.transactionHistory.add(new Transaction(TransactionType.RECEIVE, amount, this.userId));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void setDailyWithdrawalLimit(double limit) {
        if (limit > 0) {
            dailyWithdrawalLimit = limit;
            System.out.println("Daily withdrawal limit set to $" + limit);
        } else {
            System.out.println("Invalid limit amount.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}