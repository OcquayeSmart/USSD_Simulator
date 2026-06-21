public class MainMenuScreen implements MenuScreen{

    @Override
    public void render(Account account) {
        System.out.println("1. Check Balance\n2. Send Money\n3. Exit\n");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        switch (input) {
            case "1" -> {
                return new BalanceScreen();
            }
            case "2" -> {
                return new SendMoneyScreen();
            }
            case "3" -> {
                return null;
            }
            default -> System.out.println("Invalid Option");
        }
        return new MainMenuScreen();
    }
}
