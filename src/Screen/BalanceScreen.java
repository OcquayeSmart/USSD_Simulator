package Screen;

import core.MenuScreen;
import model.Account;

import java.util.Map;

public class BalanceScreen implements MenuScreen {
    private final Map<String, Account> accounts;
    public BalanceScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void render(Account account) {
        System.out.printf("You have GHS%.02f in your account\n", account.getBalance());
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        return new MainMenuScreen(accounts).handleInput(input, account);
    }
}
