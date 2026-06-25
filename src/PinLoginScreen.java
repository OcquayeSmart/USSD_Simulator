public class PinLoginScreen implements MenuScreen{
    @Override
    public void render(Account account) {
        System.out.print("Enter your pin: ");
    }
    // the user should be given only three tries to enter their pin after which they would be asked to go back to a preexisting menu

    @Override
    public MenuScreen handleInput(String input, Account account) {
        if(account.getPIN().equals(input)){
            return new MainMenuScreen();
        }
        else{
            System.out.println("Invalid Pin\n");
        }
        return new PinLoginScreen();
    }
}
