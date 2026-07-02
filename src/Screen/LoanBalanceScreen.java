package Screen;

import core.MenuScreen;
import model.Account;

import java.util.Map;

public class LoanBalanceScreen implements MenuScreen {
    private Map<String, Account> accounts;

    public LoanBalanceScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void render(Account account) {
        System.out.printf("\nYou have GHS%.02f in your account\n", account.getLoanBalance());
        System.out.println("Press 0 to go back");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        if(input.trim().equals("0")){
            return new LoanMenuScreen(accounts);
        }
        return new MainMenuScreen(accounts);
    }
}
