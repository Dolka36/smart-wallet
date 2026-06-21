public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("Иван");

        Account mainAccount = new Account(1, "Основной");

        mainAccount.addTransaction(new Transaction(10000, "доход", "RUB", "Зарплата"));
        mainAccount.addTransaction(new Transaction(1000, "доход", "RUB", "Премия"));
        mainAccount.addTransaction(new Transaction(50000, "доход", "RUB", "Акции"));
        mainAccount.addTransaction(new Transaction(5000, "расход", "RUB", "Развлечения"));
        mainAccount.addTransaction(new Transaction(100, "расход", "RUB", "Пончик"));
        mainAccount.addTransaction(new Transaction(10000, "расход", "RUB", "Кредит"));


        wallet.addAccount(mainAccount);

        System.out.println(mainAccount);


        System.out.println("Первая транзакция: " + mainAccount.transactions[0]);


        System.out.println(wallet);
    }
}
