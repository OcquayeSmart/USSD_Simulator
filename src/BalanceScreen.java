public class BalanceScreen implements MenuScreen{
    @Override
    public void render(Account account) {
        System.out.printf("You have GHS%.02f in your account\n", account.getBalance());
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        return new MainMenuScreen();
    }
}
