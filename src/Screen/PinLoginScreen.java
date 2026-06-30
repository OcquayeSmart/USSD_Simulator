package Screen;

import core.MenuScreen;
import model.Account;

import java.util.Map;

public class PinLoginScreen implements MenuScreen {
    private final Map<String, Account> accounts;
    private int attempts = 0;

    public PinLoginScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void render(Account account) {
        System.out.print("Enter your pin: ");
    }
    @Override
    public MenuScreen handleInput(String input, Account account) {
        if(account.getPIN().equals(input)){
            return new MainMenuScreen(accounts);
        }
        else{
            System.out.println("Invalid Pin");
            attempts ++;
        }
        if(attempts >= 3){
            System.out.println("Too many attempts, Bye");
            return null;
        }
        System.out.println((3-attempts) + " attempts remaining");
        return this;//returns the exact object instead of a new one to keep track of the counter
    }
}
