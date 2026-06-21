public class Main {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("Иван");

        // 1. Создаем три РАЗНЫХ типа счета
        Account debit = new DebitAccount(1, "Дебетовая карта");
        Account credit = new CreditAccount(2, "Кредитка", 10000_00); // Лимит 10 000 рублей
        Account invest = new InvestmentAccount(3, "Брокерский счет");

        // 2. Добавляем их в кошелек
        wallet.addAccount(debit);
        wallet.addAccount(credit);
        wallet.addAccount(invest);

        System.out.println("=== ТЕСТ 1: ДЕБЕТОВЫЙ СЧЕТ ===");
        debit.addTransaction(new Transaction(5000_00, "доход", "RUB", "Пополнение"));
        debit.addTransaction(new Transaction(6000_00, "расход", "RUB", "Покупка куртки")); // Должна быть ошибка!

        System.out.println("\n=== ТЕСТ 2: КРЕДИТНЫЙ СЧЕТ ===");
        credit.addTransaction(new Transaction(5000_00, "расход", "RUB", "Покупка продуктов")); // Уйдет в минус, но это разрешено
        credit.addTransaction(new Transaction(6000_00, "расход", "RUB", "Покупка кроссовок")); // Должна быть ошибка (превысим лимит)!

        System.out.println("\n=== ТЕСТ 3: ИНВЕСТИЦИОННЫЙ СЧЕТ ===");
        invest.addTransaction(new Transaction(2000_00, "доход", "RUB", "Покупка акций"));
        invest.addTransaction(new Transaction(500_00, "расход", "RUB", "Вывод денег")); // Должна быть ошибка!

        System.out.println("\n=================================");
        // Выводим финальное состояние кошелька
        System.out.println(wallet);
    }
}