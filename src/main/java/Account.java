import java.util.ArrayList;

public class Account {
    private int id;
    private String title;
    protected int balance;
    protected ArrayList<Transaction> transactions;

    public Account(int id, String title) {
        this.id = id;
        this.title = title;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        if (transaction.getType().equalsIgnoreCase("доход")) {
            balance += transaction.getAmount();
        } else if (transaction.getType().equalsIgnoreCase("расход")) {
            balance -= transaction.getAmount();
        } else {
            throw new IllegalArgumentException("Неправильная операция! Введите доход/расход");
        }

        transactions.add(transaction);
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getBalance() { return balance; }

    public int getTransactionCount() {
        return transactions.size();
    }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        double displayBalance = balance / 100.0;
        return String.format("ID: %s, Название: %s, баланс: %.2f", id, title, displayBalance);
    }
}