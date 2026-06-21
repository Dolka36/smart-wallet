import java.util.Arrays;

public class Wallet {
    private String ownerName;
    Account[] accounts;
    private int accountCount;

    public Wallet(String ownerName) {
        this.ownerName = ownerName;
        this.accounts = new Account[5];
        this.accountCount = 0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountCount() {
        return accountCount;
    }

    public void addAccount(Account account){
        if (accountCount == accounts.length){
            Account[] newAccounts = new Account[accounts.length * 2];
            for (int i = 0; i < accounts.length; i++) {
                newAccounts[i] = accounts[i];
            }
            this.accounts = newAccounts;
        }
        accounts[accountCount] = account;
        accountCount++;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Кошелек владельца: ").append(ownerName).append("\n");
        sb.append("Количество счетов: ").append(accountCount).append("\n");
        sb.append("Список счетов:\n");

        for (int i = 0; i < accountCount; i++) {
            sb.append("  - ").append(accounts[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
