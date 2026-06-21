import java.util.ArrayList;
import java.util.Arrays;

public class Wallet {
    private String ownerName;
    private ArrayList<Account> accounts;

    public Wallet(String ownerName) {
        this.ownerName = ownerName;
        this.accounts = new ArrayList<>();
    }

    public String getOwnerName() {
        return ownerName;
    }


    public void addAccount(Account account) {
        accounts.add(account);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Кошелек владельца: ").append(ownerName).append("\n");
        sb.append("Количество счетов: ").append(accounts.size()).append("\n");
        sb.append("Список счетов:\n");

        for (int i = 0; i < accounts.size(); i++) {
            sb.append("  - ").append(accounts.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
