public class PinLoginScreen implements MenuScreen{
    @Override
    public void render(Account account) {
        System.out.print("Enter your pin: ");
    }

    @Override
    public MenuScreen handleInput(String input, Account account) {
        if(account.getPIN().equals(input)){
            return new MainMenuScreen();
        }
        else{
            System.out.println("Invalid Pin");
        }
        return new PinLoginScreen();
    }
}
