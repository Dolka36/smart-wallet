public class Account {
    private int id;
    private String title;
    protected int balance;
    protected Transaction[] transactions;
    protected int transactionCount;

    public Account(int id, String title) {
        this.id = id;
        this.title = title;
        this.balance = 0;
        this.transactionCount = 0;
        this.transactions = new Transaction[5];
    }


    public void addTransaction(Transaction transaction) {
        if (transactionCount == transactions.length) {
            Transaction[] newTransactions = new Transaction[transactions.length * 2];
            for (int i = 0; i < transactions.length; i++) {
                newTransactions[i] = transactions[i];
            }
            this.transactions = newTransactions;
        }
        if (transaction.getType().equalsIgnoreCase("доход")) {
            balance += transaction.getAmount();
        } else if (transaction.getType().equalsIgnoreCase("расход")) {
            balance -= transaction.getAmount();
        } else {
            throw new IllegalArgumentException("Неправильная операция! Введите доход/расход");
        }
        transactions[transactionCount] = transaction;
        transactionCount++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    @Override
    public String toString() {
        double displayBalance = balance / 100.0;

        return String.format("ID: %s, Название: %s, баланс: %.2f", id, title, displayBalance);
    }
}
