import java.util.ArrayList;

public class Wallet {
    private String ownerName;
    private ArrayList<Account> accounts;

    public Wallet(String ownerName) {
        this.ownerName = ownerName;
        this.accounts = new ArrayList<>();
    }

    public String getOwnerName() { return ownerName; }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccountById(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Кошелек владельца: ").append(ownerName).append("\n");
        sb.append("Количество счетов: ").append(accounts.size()).append("\n");
        sb.append("Список счетов:\n");
        for (Account acc : accounts) {
            sb.append("  - ").append(acc.toString()).append("\n");
        }
        return sb.toString();
    }
}