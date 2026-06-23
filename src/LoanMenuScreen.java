public class LoanMenuScreen implements MenuScreen{

    @Override
    public void render(Account account) {
        System.out.println("Select your preferred loan option");
        System.out.println();
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        return null;
    }
}
