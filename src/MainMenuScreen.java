import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MainMenuScreen implements MenuScreen{
Map<String, Supplier<MenuScreen>> options = new HashMap<>(){{
    put("1", BalanceScreen::new);
    put("2", SendMoneyScreen::new);
    put("3", AirtimeScreen::new);
    put("4", DataBundleScreen::new);
    put("5", () -> null);
}};
    @Override
    public void render(Account account) {
        System.out.println("1. Check Balance\n2. Send Money\n3.. Buy Airtime\n4. Data Bundles\n5. Exit\n");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        Supplier<MenuScreen> action = options.get(input);
        if (action != null) {
            return action.get();
        }
        System.out.println("Invalid Option");
        return new MainMenuScreen();
    }
}
