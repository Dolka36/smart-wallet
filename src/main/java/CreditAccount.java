public class CreditAccount extends Account {
    private int creditLimit;


    public CreditAccount(int id, String title, int creditLimit) {
        super(id, title);
        this.creditLimit = creditLimit;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (transaction.getType().equalsIgnoreCase("расход")) {
            if (balance - transaction.getAmount() < -creditLimit){
                System.out.println("Ошибка: Превышен кредитный лимит на счете " + getTitle());
                return;
            }
        }
        super.addTransaction(transaction);
    }
}
