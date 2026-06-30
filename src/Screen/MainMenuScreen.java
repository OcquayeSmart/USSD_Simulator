package Screen;

import core.MenuScreen;
import model.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainMenuScreen implements MenuScreen {
    public final Map<String, Account> accounts;
    private final Map<String, Supplier<MenuScreen>> options = new HashMap<>();
    public MainMenuScreen(Map<String, Account> accounts) {
        this.accounts = accounts;
        options.put("1", () -> new BalanceScreen(accounts));
        options.put("2", () -> new SendMoneyScreen(accounts));
        options.put("3", () -> new AirtimeScreen(accounts));
        options.put("4", () -> new DataBundleScreen(accounts));
        options.put("5", () -> new LoanMenuScreen(accounts));
        options.put("6", () -> null);
    }


    @Override
    public void render(Account account) {
        System.out.print("1. Check Balance\n2. Send Money\n3. Buy Airtime\n4. Data Bundles\n5. Loans\n6. Exit\n\nEnter a value(1-6): ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        Supplier<MenuScreen> action = options.get(input);
        if (action != null) {
            return action.get();
        }
        System.out.println("Invalid Option");
        return new MainMenuScreen(accounts);
    }
}
