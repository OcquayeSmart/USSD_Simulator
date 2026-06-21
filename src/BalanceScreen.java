public class BalanceScreen implements MenuScreen{
    @Override
    public void render(Account account) {
        System.out.printf("GHS%.02f\n", account.getBalance());
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        return new MainMenuScreen();
    }
}
