public class LoanBalanceScreen implements MenuScreen{

    @Override
    public void render(Account account) {
        System.out.printf("GHS%.02f\n", account.getLoanBalance());
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        return new MainMenuScreen();
    }
}
