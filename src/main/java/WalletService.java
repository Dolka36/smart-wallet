import java.util.Scanner;

public class WalletService {
    private Wallet wallet;
    private Scanner scanner;

    public WalletService() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добро пожаловать в Умный Кошелек!");
        System.out.print("Введите имя владельца кошелька: ");
        String name = scanner.nextLine();
        this.wallet = new Wallet(name);
        runMenu();
    }

    private void runMenu() {
        while (true) {
            System.out.println("\n--- ГЛАВНОЕ МЕНЮ ---");
            System.out.println("1. Показать состояние кошелька");
            System.out.println("2. Добавить новый счет");
            System.out.println("3. Добавить транзакцию (Доход/Расход)");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println(wallet);
            } else if (choice == 2) {
                createNewAccount();
            } else if (choice == 3) {
                createNewTransaction();
            } else if (choice == 0) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Неверный пункт меню. Попробуйте снова.");
            }
        }
    }

    private void createNewAccount() {
        System.out.println("\n--- СОЗДАНИЕ НОВОГО СЧЕТА ---");
        System.out.println("Выберите тип счета: 1 - Дебетовый, 2 - Кредитный, 3 - Инвестиционный");
        System.out.print("Ваш выбор: ");
        int type = scanner.nextInt();

        System.out.print("Введите уникальный ID счета (число): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите название счета: ");
        String title = scanner.nextLine();

        Account newAccount = null;

        if (type == 1) {
            newAccount = new DebitAccount(id, title);
        } else if (type == 2) {
            System.out.print("Введите кредитный лимит (в рублях): ");
            int limitInRubles = scanner.nextInt();
            scanner.nextLine();
            newAccount = new CreditAccount(id, title, limitInRubles * 100);
        } else if (type == 3) {
            newAccount = new InvestmentAccount(id, title);
        } else {
            System.out.println("Неверный тип счета!");
            return;
        }

        if (newAccount != null) {
            wallet.addAccount(newAccount);
            System.out.println("Счет успешно добавлен!");
        }
    }

    private void createNewTransaction() {
        System.out.println("\n--- ДОБАВЛЕНИЕ ТРАНЗАКЦИИ ---");
        System.out.print("Введите ID счета: ");
        int targetId = scanner.nextInt();
        scanner.nextLine();

        Account account = wallet.findAccountById(targetId);
        if (account == null) {
            System.out.println("Ошибка: Счет не найден!");
            return;
        }

        System.out.print("Введите тип операции (доход/расход): ");
        String type = scanner.nextLine();

        System.out.print("Введите сумму в рублях: ");
        int amountInRubles = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите валюту (например, RUB): ");
        String currency = scanner.nextLine();

        System.out.print("Введите описание: ");
        String description = scanner.nextLine();

        Transaction transaction = new Transaction(amountInRubles * 100, type, currency, description);
        account.addTransaction(transaction);
    }
}