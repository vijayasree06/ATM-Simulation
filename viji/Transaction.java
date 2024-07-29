public class Transaction {
    private TransactionType type;
    private double amount;
    private String otherParty; 

    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.otherParty = null;
    }

    public Transaction(TransactionType type, double amount, String otherParty) {
        this.type = type;
        this.amount = amount;
        this.otherParty = otherParty;
    }

    @Override
    public String toString() {
        if (otherParty == null) {
            return type + ": $" + amount;
        } else {
            return type + ": $" + amount + " to/from " + otherParty;
        }
    }
}