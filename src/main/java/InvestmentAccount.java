public class InvestmentAccount extends Account {

    public InvestmentAccount(int id, String title) {
        super(id, title);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (transaction.getType().equalsIgnoreCase("расход")) {
            System.out.println("Ошибка: С инвестиционного счета нельзя списывать средства!");
            return;
        }
        super.addTransaction(transaction);
    }
}
