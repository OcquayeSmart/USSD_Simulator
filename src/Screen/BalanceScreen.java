package Screen;

import core.MenuScreen;
import model.Account;

public class BalanceScreen implements MenuScreen {
    @Override
    public void render(Account account) {
        System.out.printf("You have GHS%.02f in your account\n", account.getBalance());
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        return new MainMenuScreen().handleInput(input, account);
    }
}
