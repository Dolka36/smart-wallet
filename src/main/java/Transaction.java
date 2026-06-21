public class Transaction {
    private int amount;
    private String currency;
    private String type;
    private String description;


    public Transaction(int amount, String type, String currency, String description) {
        this.amount = amount;
        this.type = type;
        this.currency = currency;
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        double displayAmount = amount / 100.0;

        return String.format("Транзакция [%s] - Сумма: %.2f %s, Описание: %s",
                type, displayAmount, currency, description);
    }
}
