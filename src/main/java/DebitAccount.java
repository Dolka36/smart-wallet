public class DebitAccount extends Account {
    public DebitAccount(int id, String title) {
        super(id, title);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (transaction.getType().equalsIgnoreCase("расход")) {
            if (balance < transaction.getAmount()) {
                System.out.println("Ошибка: Недостаточно средств на счете " + getTitle());
                return;
            }
        }
        super.addTransaction(transaction);
    }
}